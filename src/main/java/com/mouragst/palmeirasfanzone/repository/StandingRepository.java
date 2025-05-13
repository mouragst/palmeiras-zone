package com.mouragst.palmeirasfanzone.repository;

import com.mouragst.palmeirasfanzone.model.Standing;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mouragst.palmeirasfanzone.model.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StandingRepository extends JpaRepository<Standing, Long> {

    @Query("SELECT s FROM Standing s " +
           "WHERE s.team = :team AND s.competition.code = :competitionCode")
    Standing findByTeamAndCompetitionCode(Team team, String competitionCode);

    @Query("SELECT s FROM Standing s " +
       "ORDER BY s.competition.id ASC, s.points DESC")
    List<Standing> findAndGroupByCompetitionAndPoints();

}