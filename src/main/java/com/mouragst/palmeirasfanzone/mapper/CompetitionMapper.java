package com.mouragst.palmeirasfanzone.mapper;

import com.mouragst.palmeirasfanzone.dto.CompetitionDTO;
import com.mouragst.palmeirasfanzone.model.Competition;

public interface CompetitionMapper {

    public static CompetitionDTO toDTO(Competition competition) {
        if (competition == null) { return null; }

        return new CompetitionDTO(
            competition.getId(),
            competition.getName(),
            competition.getCode(),
            competition.getType(),
            competition.getEmblem()
        );
    }
}
