package com.mouragst.palmeirasfanzone.service;

import com.mouragst.palmeirasfanzone.repository.SquadRepository;
import com.mouragst.palmeirasfanzone.dto.SquadDTO;
import com.mouragst.palmeirasfanzone.mapper.SquadMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SquadService {

    private final SquadRepository squadRepository;

    public SquadService(SquadRepository squadRepository) {
        this.squadRepository = squadRepository;
    }

    public List<SquadDTO> getSquad() {
        return squadRepository.findAll()
                .stream()
                .map(SquadMapper::toDTO)
                .toList();
    }
}
