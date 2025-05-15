package com.mouragst.palmeirasfanzone.controller;

import com.mouragst.palmeirasfanzone.dto.MatchDTO;
import com.mouragst.palmeirasfanzone.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public List<MatchDTO> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("/{id}")
    public MatchDTO getMatchById(@PathVariable Long id) {
        return matchService.getMatchById(id);
    }

    @GetMapping("/last")
    public MatchDTO getLastPlayedMatch() {
        return matchService.getLastPlayedMatch();
    }

    @GetMapping("/live")
    public List<MatchDTO> getLiveMatches() {
        return matchService.getLiveMatches();
    }
}
