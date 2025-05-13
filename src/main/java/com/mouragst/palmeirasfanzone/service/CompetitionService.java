package com.mouragst.palmeirasfanzone.service;

import com.mouragst.palmeirasfanzone.model.Competition;
import com.mouragst.palmeirasfanzone.dto.CompetitionDTO;
import com.mouragst.palmeirasfanzone.repository.CompetitionRepository;
import com.mouragst.palmeirasfanzone.mapper.CompetitionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {
    
    private final CompetitionRepository competitionRepository;

    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public List<CompetitionDTO> getAllCompetitions() {
        return competitionRepository.findAll()
                .stream()
                .map(CompetitionMapper::toDTO)
                .toList();
    }

    public CompetitionDTO getCompetitionById(Long id) {
        Competition competition = competitionRepository.findById(id).orElse(null);
        return competition != null ? CompetitionMapper.toDTO(competition) : null;
    }

    public CompetitionDTO getCompetitionByCode(String code) {
        Competition competition = competitionRepository.findByCode(code);
        return competition != null ? CompetitionMapper.toDTO(competition) : null;
    }
}
