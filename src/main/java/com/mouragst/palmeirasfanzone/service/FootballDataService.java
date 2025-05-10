package com.mouragst.palmeirasfanzone.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mouragst.palmeirasfanzone.model.Match;
import com.mouragst.palmeirasfanzone.model.Season;
import com.mouragst.palmeirasfanzone.model.Squad;
import com.mouragst.palmeirasfanzone.model.Competition;
import com.mouragst.palmeirasfanzone.model.Standing;
import com.mouragst.palmeirasfanzone.model.Team;
import com.mouragst.palmeirasfanzone.repository.CompetitionRepository;
import com.mouragst.palmeirasfanzone.repository.TeamRepository;
import com.mouragst.palmeirasfanzone.repository.SeasonRepository;
import com.mouragst.palmeirasfanzone.repository.SquadRepository;
import com.mouragst.palmeirasfanzone.repository.MatchRepository;
import com.mouragst.palmeirasfanzone.repository.StandingRepository;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class FootballDataService {
    
    @Value("${FOOTBALL_API_KEY}")
    private String apiKey;

    @Value("${FOOTBALL_API_URL}")
    private String apiUrl;

    @Value("${TEAM_ID}")
    private String teamId;

    private final RestTemplate restTemplate;

    private final StandingRepository standingRepository;
    private final CompetitionRepository competitionRepository;
    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;
    private final ObjectMapper objectMapper;
    private final SquadRepository squadRepository;
    private final SeasonRepository seasonRepository;

    public FootballDataService(RestTemplate restTemplate, CompetitionRepository competitionRepository,
                            TeamRepository teamRepository, MatchRepository matchRepository,
                            StandingRepository standingRepository, ObjectMapper objectMapper, 
                            SquadRepository squadRepository, SeasonRepository seasonRepository) {
        this.restTemplate = restTemplate;
        this.competitionRepository = competitionRepository;
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
        this.standingRepository = standingRepository;
        this.objectMapper = objectMapper;
        this.squadRepository = squadRepository;
        this.seasonRepository = seasonRepository;
    }

    public String getStandings(String code) {
        String url = apiUrl + "/competitions/" + code + "/standings";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Auth-Token", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, org.springframework.http.HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    public String getMatches() {
        String url = apiUrl + "/teams/" + teamId + "/matches";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Auth-Token", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, org.springframework.http.HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    public String getTeamData() {
        String url = apiUrl + "/teams/" + teamId;
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Auth-Token", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, org.springframework.http.HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    @Transactional
    public void fetchAndSaveSquad() throws Exception {
        String response = getTeamData();
        JsonNode root = objectMapper.readTree(response);

        if (root == null || root.path("squad").isEmpty()) {
            throw new Exception("No squad found in the response.");
        }

        JsonNode coachNode = root.path("coach");
        for (JsonNode coach : coachNode) {
            Long coachId = coach.path("id").asLong();
            squadRepository.findById(coachId).orElseGet(() -> {
                Squad newSquad = buildSquad(coach);
                return squadRepository.save(newSquad);
            });
        }

        JsonNode squadNodes = root.path("squad");
        for (JsonNode playerNode : squadNodes) {
            Long playerId = playerNode.path("id").asLong();
            squadRepository.findById(playerId).orElseGet(() -> {
                Squad newSquad = buildSquad(playerNode);
                return squadRepository.save(newSquad);
            });
        }
    }

    @Transactional
    public void fetchAndSaveStandings() throws Exception {
        List<String> codes = competitionRepository.findAllBy()
                                          .stream()
                                          .map(Competition::getCode)
                                          .collect(Collectors.toList());
        
        for (String code : codes) {
            String response = getStandings(code);
            JsonNode root = objectMapper.readTree(response);

            if (root == null || root.path("standings").isEmpty()) {
                throw new Exception("No standings found in the response.");
            }

            JsonNode standings = root.path("standings");
            for (JsonNode standingNode : standings) {
                JsonNode tableNode = standingNode.path("table");
                for (JsonNode teamNode : tableNode) {
                    Long teamId = teamNode.path("team").path("id").asLong();
                    Team team = teamRepository.findById(teamId).orElseGet(() -> {
                        Team newTeam = buildTeam(teamNode);
                        return teamRepository.save(newTeam);
                    });

                    Standing standing = buildStanding(teamNode, code, team);
                    standingRepository.save(standing);
                }
            }
        }
    }

    @Transactional
    public void fetchAndSaveMatches() throws Exception {
        String response = getMatches();
        JsonNode root = objectMapper.readTree(response);

        if (root == null || root.path("matches").isEmpty()) {
            throw new Exception("No matches found in the response.");
        }

        JsonNode matches = root.path("matches");
        for (JsonNode matchNode : matches) {
            JsonNode competitionNode = matchNode.path("competition");
            Competition competition = null;

            Long competitionId = competitionNode.path("id").asLong();
            if (competitionNode != null) {
                competition = competitionRepository.findById(competitionId).orElseGet(() -> {
                    Competition newCompetition = buildCompetition(competitionNode);
                    return competitionRepository.save(newCompetition);
                });
            }

            JsonNode seasonNode = matchNode.path("season");
            Season season = null;
            Long seasonId = seasonNode.path("id").asLong();
            if (seasonNode != null) {
                season = seasonRepository.findById(seasonId).orElseGet(() -> {
                    Season newSeason = buildSeason(seasonNode);
                    return seasonRepository.save(newSeason);
                });
            }
            
            JsonNode awayTeamNode = matchNode.path("awayTeam");
            Long awayTeamId = awayTeamNode.path("id").asLong();
            Team awayTeam = teamRepository.findById(awayTeamId).orElseGet(() -> {
                Team newAwayTeam = buildTeam(awayTeamNode);
                return teamRepository.save(newAwayTeam);
            });

            JsonNode homeTeamNode = matchNode.path("homeTeam");
            Long homeTeamId = homeTeamNode.path("id").asLong();
            Team homeTeam = teamRepository.findById(homeTeamId).orElseGet(() -> {
                Team team = buildTeam(homeTeamNode);
                return teamRepository.save(team);
            });

            Match match = buildMatch(matchNode, homeTeam, awayTeam, competition, season);
            matchRepository.save(match);
        }
    }

    private Squad buildSquad(JsonNode playerNode) {
        Squad squad = new Squad();
        squad.setId(playerNode.path("id").asLong());
        squad.setName(playerNode.path("name").asText());
        squad.setPosition(playerNode.path("position").asText());
        squad.setNationality(playerNode.path("nationality").asText());

        String dateOfBirth = playerNode.path("dateOfBirth").asText();
        if (dateOfBirth != null && !dateOfBirth.isEmpty()) {
            try {
                squad.setDateOfBirth(Date.from(ZonedDateTime
                    .parse(dateOfBirth, DateTimeFormatter.ISO_ZONED_DATE_TIME)
                    .toInstant()));
            } catch (Exception e) {
                squad.setDateOfBirth(null);
            }
        } else {
            squad.setDateOfBirth(null);
        }

        return squad;
    }

    private Standing buildStanding(JsonNode teamNode, String code, Team team) {
        Standing standing = new Standing();
        standing.setId(teamNode.path("team").path("id").asLong());
        standing.setCompetition(competitionRepository.findByCode(code));
        standing.setTeam(team);
        standing.setPosition(teamNode.path("position").asInt());
        standing.setPoints(teamNode.path("points").asInt());
        standing.setWins(teamNode.path("won").asInt());
        standing.setDraws(teamNode.path("draw").asInt());
        standing.setLosses(teamNode.path("lost").asInt());
        standing.setGoalsFor(teamNode.path("goalsFor").asInt());
        standing.setGoalsAgainst(teamNode.path("goalsAgainst").asInt());
        standing.setGoalDifference(teamNode.path("goalDifference").asInt());
        standing.setLastUpdated(LocalDateTime.now());
        return standing;
    }

    private Competition buildCompetition(JsonNode competitionNode) {
        Competition competition = new Competition();
        competition.setId(competitionNode.path("id").asLong());
        competition.setName(competitionNode.path("name").asText());
        competition.setCode(competitionNode.path("code").asText());
        competition.setType(competitionNode.path("type").asText());
        competition.setEmblem(competitionNode.path("emblem").asText());
        return competition;
    }

    private Team buildTeam(JsonNode teamNode) {
        Team team = new Team();
        team.setId(teamNode.path("id").asLong());
        team.setName(teamNode.path("name").asText());
        team.setShortName(teamNode.path("shortName").asText());
        team.setTla(teamNode.path("tla").asText());
        team.setCrest(teamNode.path("crest").asText());
        return team;
    }

    private Season buildSeason(JsonNode seasonNode) {
        Season season = new Season();
        season.setId(seasonNode.path("id").asLong());
        season.setStartDate(seasonNode.path("startDate").asText());
        season.setEndDate(seasonNode.path("endDate").asText());
        season.setWinner(seasonNode.path("winner").asText());
        return season;
    }

    private Match buildMatch(JsonNode matchNode, Team homeTeam, Team awayTeam, Competition competition, Season season) {
        Match match = new Match();
        match.setId(matchNode.path("id").asLong());
        match.setMatchDate(ZonedDateTime.
              parse(matchNode.path("utcDate").
              asText(), DateTimeFormatter.ISO_ZONED_DATE_TIME).
              toLocalDateTime());
        match.setCompetition(competition);
        match.setHomeTeam(homeTeam);
        match.setAwayTeam(awayTeam);
        match.setSeason(season);
        match.setStatus(matchNode.path("status").asText());
        if ("FINISHED".equals(match.getStatus())) {
            match.setHomeScore(matchNode.path("score").path("fullTime").path("home").asInt());
            match.setAwayScore(matchNode.path("score").path("fullTime").path("away").asInt());
        }
        return match;
    }
}
