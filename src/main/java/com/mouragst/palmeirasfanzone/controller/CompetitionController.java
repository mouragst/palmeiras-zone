package com.mouragst.palmeirasfanzone.controller;

import com.mouragst.palmeirasfanzone.model.Competition;
import com.mouragst.palmeirasfanzone.service.CompetitionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competitions")
public class CompetitionController {
    
    private final CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping
    public List<Competition> getAllCompetitions() {
        return competitionService.getAllCompetitions();
    }

    @GetMapping("/{id}")
    public Competition getCompetitionById(@PathVariable Long id) {
        return competitionService.getCompetitionById(id);
    }

    @GetMapping("/code/{code}")
    public Competition getCompetitionByCode(@PathVariable String code) {
        return competitionService.getCompetitionByCode(code);
    }
}
