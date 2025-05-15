package com.mouragst.palmeirasfanzone.repository;

import com.mouragst.palmeirasfanzone.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findByIsLive(boolean isLive);


    @Query("SELECT m FROM Match m WHERE m.status = 'finished' ORDER BY m.matchDate DESC LIMIT 1")
    Match findLastMatchPlayed();
}
