package com.mouragst.palmeirasfanzone.controller;

import com.mouragst.palmeirasfanzone.model.Standing;
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
    public List<Standing> getStandings() {
        return standingService.getStandings();
    }
}
