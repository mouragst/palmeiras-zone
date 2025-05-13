package com.mouragst.palmeirasfanzone.mapper;

import com.mouragst.palmeirasfanzone.model.Squad;
import com.mouragst.palmeirasfanzone.dto.SquadDTO;

public class SquadMapper {

    public static SquadDTO toDTO(Squad squad) {
        
        if (squad == null) { return null; }

        return new SquadDTO(
            squad.getId(),
            squad.getName(),
            squad.getPosition(),
            squad.getAge(),
            squad.getNationality(),
            squad.getDateOfBirth(),
            squad.getLastUpdated()
        );
    }
    
}
