package com.mouragst.palmeirasfanzone.mapper;

import com.mouragst.palmeirasfanzone.model.Team;
import com.mouragst.palmeirasfanzone.dto.TeamDTO;

public class TeamMapper {
    
    public static TeamDTO toDTO(Team team) {
        if (team == null) { return null; }
        
        return new TeamDTO(
            team.getId(),
            team.getName(),
            team.getShortName(),
            team.getTla(),
            team.getCrest()
        );
    }
}
