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
    List<String> ordemPosicoes = List.of(
        "Goalkeeper", "Defence", "Midfield", "Offence", "Centre-Forward", "Left Winger", "Coach"
    );

    return squadRepository.findAll()
            .stream()
            .map(SquadMapper::toDTO)
            .sorted((a, b) -> {
                int idxA = ordemPosicoes.indexOf(a.getPosition());
                int idxB = ordemPosicoes.indexOf(b.getPosition());
                if (idxA == -1) idxA = ordemPosicoes.size();
                if (idxB == -1) idxB = ordemPosicoes.size();
                return Integer.compare(idxA, idxB);
            })
            .toList();
}
}
