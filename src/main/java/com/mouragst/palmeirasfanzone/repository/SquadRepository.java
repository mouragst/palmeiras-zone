package com.mouragst.palmeirasfanzone.repository;

import com.mouragst.palmeirasfanzone.model.Squad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquadRepository extends JpaRepository<Squad, Long> {

}
