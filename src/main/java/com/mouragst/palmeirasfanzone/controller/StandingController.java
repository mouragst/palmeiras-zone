package com.mouragst.palmeirasfanzone.controller;

import com.mouragst.palmeirasfanzone.dto.StandingDTO;
import com.mouragst.palmeirasfanzone.service.StandingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/standings")
public class StandingController {
    
    private final StandingService standingService;

    public StandingController(StandingService standingService) {
        this.standingService = standingService;
    }

    @GetMapping
    public List<StandingDTO> getStandings() {
        return standingService.getStandings();
    }
}
