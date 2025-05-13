package com.mouragst.palmeirasfanzone.mapper;

import com.mouragst.palmeirasfanzone.dto.StandingDTO;
import com.mouragst.palmeirasfanzone.dto.CompetitionDTO;
import com.mouragst.palmeirasfanzone.dto.TeamDTO;
import com.mouragst.palmeirasfanzone.model.Standing;

public class StandingMapper {
    
    public static StandingDTO toDTO(Standing standing) {
        if (standing == null) { return null; }

        return new StandingDTO(
            standing.getId(),
            new CompetitionDTO(
                standing.getCompetition().getId(),
                standing.getCompetition().getName(),
                standing.getCompetition().getCode(),
                standing.getCompetition().getType(),
                standing.getCompetition().getEmblem()
            ),
            new TeamDTO(
                standing.getTeam().getId(),
                standing.getTeam().getName(),
                standing.getTeam().getShortName(),
                standing.getTeam().getTla(),
                standing.getTeam().getCrest()
            ),
            standing.getPosition(),
            standing.getPoints(),
            standing.getWins(),
            standing.getDraws(),
            standing.getLosses(),
            standing.getGoalsFor(),
            standing.getGoalsAgainst(),
            standing.getGoalDifference(),
            standing.getLastUpdated(),
            standing.getGroupName()
        );
    }
}
