package com.mouragst.palmeirasfanzone.repository;

import com.mouragst.palmeirasfanzone.model.Standing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandingRepository extends JpaRepository<Standing, Long> {

}