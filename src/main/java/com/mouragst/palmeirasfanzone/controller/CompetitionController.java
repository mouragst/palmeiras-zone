package com.mouragst.palmeirasfanzone.controller;

import com.mouragst.palmeirasfanzone.service.CompetitionService;
import com.mouragst.palmeirasfanzone.dto.CompetitionDTO;
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
    public List<CompetitionDTO> getAllCompetitions() {
        return competitionService.getAllCompetitions();
    }

    @GetMapping("/{id}")
    public CompetitionDTO getCompetitionById(@PathVariable Long id) {
        return competitionService.getCompetitionById(id);
    }

    @GetMapping("/code/{code}")
    public CompetitionDTO getCompetitionByCode(@PathVariable String code) {
        return competitionService.getCompetitionByCode(code);
    }
}
