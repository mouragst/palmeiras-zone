package com.mouragst.palmeirasfanzone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mouragst.palmeirasfanzone.service.FootballDataService;

@RestController
@RequestMapping("/api/football")
public class FootballDataController {

    private final FootballDataService footballDataService;

    public FootballDataController(FootballDataService footballDataService) {
        this.footballDataService = footballDataService;
    }

    @GetMapping("/update-squad")
    public String updateSquad() {
        try {
            footballDataService.fetchAndSaveSquad();
            return "Squad updated successfully!";
        } catch (Exception e) {
            return "Error updating squad: " + e.getMessage();
        }
    }

    @GetMapping("/update-matches")
    public String updateMatches() {
        try {
            footballDataService.fetchAndSaveMatches();
            return "Matches updated successfully!";
        } catch (Exception e) {
            return "Error updating matches: " + e.getMessage();
        }
    }

    @GetMapping("/update-standings")
    public String updateStandings() {
        try {
            footballDataService.fetchAndSaveStandings();
            return "Standings updated successfully!";
        } catch (Exception e) {
            return "Error updating standings: " + e.getMessage();
        }
    }

    @GetMapping("/update-all")
    public String updateEverything() {
        StringBuilder result = new StringBuilder();

        try {
            result.append(updateSquad()).append("\n");
        } catch (Exception e) {
            result.append("Error updating squad: ").append(e.getMessage()).append("\n");
        }

        try {
            result.append(updateMatches()).append("\n");
        } catch (Exception e) {
            result.append("Error updating matches: ").append(e.getMessage()).append("\n");
        }

        try {
            result.append(updateStandings()).append("\n");
        } catch (Exception e) {
            result.append("Error updating standings: ").append(e.getMessage()).append("\n");
        }

        return result.toString();
    }
}