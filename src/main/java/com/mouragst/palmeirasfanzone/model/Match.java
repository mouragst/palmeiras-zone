package com.mouragst.palmeirasfanzone.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "matches")
public class Match {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "home_team_id", nullable = false)
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id", nullable = false)
    private Team awayTeam;

    @ManyToOne
    @JoinColumn(name = "competition_id", nullable = false)
    private Competition competition;

    @Column(nullable = false)
    private LocalDateTime matchDate;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    private Season season;

    private Integer homeScore;
    private Integer awayScore;
    private boolean isLive;

    @Column(nullable = false)
    private LocalDateTime lastUpdated;

    public Match() {
        this.isLive = false;
        this.lastUpdated = LocalDateTime.now();
    }

}