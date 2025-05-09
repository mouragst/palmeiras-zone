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

    private Integer season;
    private Integer homeScore;
    private Integer awayScore;
    private boolean isLive;

    public Match() {
        this.isLive = false;
    }

}