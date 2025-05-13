package com.mouragst.palmeirasfanzone.service;

import com.mouragst.palmeirasfanzone.repository.StandingRepository;
import com.mouragst.palmeirasfanzone.dto.StandingDTO;
import com.mouragst.palmeirasfanzone.mapper.StandingMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandingService {
    
    private final StandingRepository standingRepository;

    public StandingService(StandingRepository standingRepository) {
        this.standingRepository = standingRepository;
    }

    public List<StandingDTO> getStandings() {
        return standingRepository.findAndGroupByCompetitionAndPoints()
                .stream()
                .map(StandingMapper::toDTO)
                .toList();
    }

}
