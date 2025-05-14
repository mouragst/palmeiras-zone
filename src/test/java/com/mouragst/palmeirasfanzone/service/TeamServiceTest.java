package com.mouragst.palmeirasfanzone.service;

import com.mouragst.palmeirasfanzone.dto.TeamDTO;
import com.mouragst.palmeirasfanzone.model.Team;
import com.mouragst.palmeirasfanzone.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TeamServiceTest {

    private final TeamRepository teamRepository = mock(TeamRepository.class);
    private final TeamService teamService = new TeamService(teamRepository);

    @Test
    void testGetAllTeams() {
        Team team = new Team();
        team.setId(1L);
        team.setName("Palmeiras");
        team.setShortName("PAL");
        team.setTla("PAL");
        team.setCrest("crest_url");

        when(teamRepository.findAll()).thenReturn(List.of(team));

        List<TeamDTO> teams = teamService.getAllTeams();

        assertEquals(1, teams.size());
        assertEquals("Palmeiras", teams.get(0).getName());
        verify(teamRepository, times(1)).findAll();
    }
}