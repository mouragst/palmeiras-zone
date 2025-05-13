package com.mouragst.palmeirasfanzone.service;

import com.mouragst.palmeirasfanzone.model.Match;
import com.mouragst.palmeirasfanzone.repository.MatchRepository;
import com.mouragst.palmeirasfanzone.dto.MatchDTO;
import com.mouragst.palmeirasfanzone.mapper.MatchMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<MatchDTO> getAllMatches() {
        return matchRepository.findAll()
                .stream()
                .map(MatchMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MatchDTO getLastPlayedMatch() {
        Match lastMatch = matchRepository.findLastMatchPlayed();
        return lastMatch != null ? MatchMapper.toDTO(lastMatch) : null;
    }

    public List<MatchDTO> getLiveMatches() {
        return matchRepository.findByIsLive(true)
                .stream()
                .map(MatchMapper::toDTO)
                .collect(Collectors.toList());
    }
}
