package com.mouragst.palmeirasfanzone.mapper;

import com.mouragst.palmeirasfanzone.dto.SeasonDTO;
import com.mouragst.palmeirasfanzone.model.Season;

public interface SeasonMapper {

    public static SeasonDTO toDTO(Season season) {
        if (season == null) { return null; }

        return new SeasonDTO(
        season.getId(),
        season.getStartDate(),
        season.getEndDate(),
        season.getWinner()
        );
    }
}
