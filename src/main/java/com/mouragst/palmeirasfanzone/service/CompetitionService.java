package com.mouragst.palmeirasfanzone.service;

import com.mouragst.palmeirasfanzone.model.Competition;
import com.mouragst.palmeirasfanzone.repository.CompetitionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {
    
    private final CompetitionRepository competitionRepository;

    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public List<Competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    public Competition getCompetitionById(Long id) {
        return competitionRepository.findById(id).orElse(null);
    }

    public Competition getCompetitionByCode(String code) {
        return competitionRepository.findByCode(code);
    }
}
