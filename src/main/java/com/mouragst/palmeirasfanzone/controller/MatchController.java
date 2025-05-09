package com.mouragst.palmeirasfanzone.controller;

import com.mouragst.palmeirasfanzone.model.Match;
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
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("/live")
    public List<Match> getLiveMatches() {
        return matchService.getLiveMatches();
    }

    @PostMapping
    public Match saveMatch(@RequestBody Match match) {
        return matchService.saveMatch(match);
    }
}
