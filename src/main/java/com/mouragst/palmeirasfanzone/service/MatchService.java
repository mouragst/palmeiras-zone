package com.mouragst.palmeirasfanzone.service;

import com.mouragst.palmeirasfanzone.model.Match;
import com.mouragst.palmeirasfanzone.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match getLastPlayedMatch() {
        return matchRepository.findLastMatchPlayed();
    }

    public List<Match> getLiveMatches() {
        return matchRepository.findByIsLive(true);
    }

    public List<Match> getNotLiveMatches() {
        return matchRepository.findByIsLive(false);
    }
}
