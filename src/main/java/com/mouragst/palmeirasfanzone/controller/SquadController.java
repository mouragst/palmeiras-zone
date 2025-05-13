package com.mouragst.palmeirasfanzone.controller;

import com.mouragst.palmeirasfanzone.model.Squad;
import com.mouragst.palmeirasfanzone.service.SquadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/squad")
public class SquadController {

    private final SquadService squadService;

    public SquadController(SquadService squadService) {
        this.squadService = squadService;
    }

    @GetMapping
    public List<Squad> getSquad() {
        return squadService.getSquad();
    }
}
