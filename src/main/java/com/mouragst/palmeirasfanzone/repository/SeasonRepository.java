package com.mouragst.palmeirasfanzone.repository;

import com.mouragst.palmeirasfanzone.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {

}
