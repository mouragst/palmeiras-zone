package com.mouragst.palmeirasfanzone.repository;

import com.mouragst.palmeirasfanzone.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {

    List<Competition> findAllBy();
    Competition findByCode(String code);
}