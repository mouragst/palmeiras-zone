package com.mouragst.palmeirasfanzone.service;

import com.mouragst.palmeirasfanzone.model.Team;
import com.mouragst.palmeirasfanzone.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    public Team getTeamByCode(String tla) {
        return teamRepository.findByTla(tla);
    }
    
}
