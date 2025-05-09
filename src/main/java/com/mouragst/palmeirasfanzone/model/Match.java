package com.mouragst.palmeirasfanzone.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String homeTeam;

    @Column(nullable = false)
    private String awayTeam;

    @Column(nullable = false)
    private String competition;

    @Column(nullable = false)
    private LocalDateTime matchDate;

    private Integer homeScore;
    private Integer awayScore;
    private boolean isLive;
}
