package com.mouragst.palmeirasfanzone.mapper;

import com.mouragst.palmeirasfanzone.model.Match;
import com.mouragst.palmeirasfanzone.dto.CompetitionDTO;
import com.mouragst.palmeirasfanzone.dto.MatchDTO;
import com.mouragst.palmeirasfanzone.dto.SeasonDTO;
import com.mouragst.palmeirasfanzone.dto.TeamDTO;

public class MatchMapper {

    public static MatchDTO toDTO(Match match) {
        if (match == null) { return null; }

        return new MatchDTO(
            match.getId(),
            new TeamDTO(
                match.getHomeTeam().getId(),
                match.getHomeTeam().getName(),
                match.getHomeTeam().getShortName(),
                match.getHomeTeam().getTla(),
                match.getHomeTeam().getCrest()
            ),
            new TeamDTO(
                match.getAwayTeam().getId(),
                match.getAwayTeam().getName(),
                match.getAwayTeam().getShortName(),
                match.getAwayTeam().getTla(),
                match.getAwayTeam().getCrest()
            ),
            new CompetitionDTO(
                match.getCompetition().getId(),
                match.getCompetition().getName(),
                match.getCompetition().getCode(),
                match.getCompetition().getType(),
                match.getCompetition().getEmblem()
            ),
            new SeasonDTO(
                match.getSeason().getId(),
                match.getSeason().getStartDate(),
                match.getSeason().getEndDate(),
                match.getSeason().getWinner()
            ),
            match.getMatchDate(),
            match.getStatus(),
            match.isLive(),
            match.getHomeScore(),
            match.getAwayScore(),
            match.getLastUpdated()
        );
    }

    public static Match toEntity(MatchDTO dto) {
        Match match = new Match();
        match.setId(dto.getId());
        match.setMatchDate(dto.getMatchDate());
        match.setStatus(dto.getStatus());
        match.setLive(dto.isLive());
        match.setHomeScore(dto.getHomeScore());
        match.setAwayScore(dto.getAwayScore());
        return match;
    }
}
