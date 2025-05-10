package com.mouragst.palmeirasfanzone.service;

import com.mouragst.palmeirasfanzone.model.Squad;
import com.mouragst.palmeirasfanzone.repository.SquadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SquadService {

    private final SquadRepository squadRepository;

    public SquadService(SquadRepository squadRepository) {
        this.squadRepository = squadRepository;
    }

    public List<Squad> getSquad() {
        return squadRepository.findAll();
    }
}
