package com.mouragst.palmeirasfanzone.controller;

import com.mouragst.palmeirasfanzone.dto.TeamDTO;
import com.mouragst.palmeirasfanzone.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<TeamDTO> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public TeamDTO getTeamById(@PathVariable Long id) {
        return teamService.getTeamById(id);
    }

    @GetMapping("/code/{code}")
    public TeamDTO getTeamByCode(@PathVariable String code) {
        return teamService.getTeamByCode(code);
    }
    
}
