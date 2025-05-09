package com.mouragst.palmeirasfanzone.repository;

import com.mouragst.palmeirasfanzone.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findByIsLive(boolean isLive);   
}
