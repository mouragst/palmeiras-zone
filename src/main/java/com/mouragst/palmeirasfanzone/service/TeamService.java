package com.mouragst.palmeirasfanzone.service;

import com.mouragst.palmeirasfanzone.model.Team;
import com.mouragst.palmeirasfanzone.dto.TeamDTO;
import com.mouragst.palmeirasfanzone.mapper.TeamMapper;
import com.mouragst.palmeirasfanzone.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository; 

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<TeamDTO> getAllTeams() {
        return teamRepository.findAll()
                .stream()
                .map(TeamMapper::toDTO)
                .toList();
    }

    public TeamDTO getTeamById(Long id) {
        Team team = teamRepository.findById(id).orElse(null);
        return team != null ? TeamMapper.toDTO(team) : null;
    }

    public TeamDTO getTeamByCode(String tla) {
        Team team = teamRepository.findByTla(tla);
        return team != null ? TeamMapper.toDTO(team) : null;
    }
    
}
