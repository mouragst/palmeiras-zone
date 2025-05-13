package com.mouragst.palmeirasfanzone.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "standings")
public class Standing {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "competition_id", nullable = false)
    private Competition competition;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @Column(nullable = false)
    private Integer position;

    @Column(nullable = false)
    private Integer points;

    @Column(nullable = false)
    private Integer wins;

    @Column(nullable = false)
    private Integer draws;

    @Column(nullable = false)
    private Integer losses;

    @Column(nullable = false)
    private Integer goalsFor;

    @Column(nullable = false)
    private Integer goalsAgainst;

    @Column(nullable = false)
    private Integer goalDifference;

    @Column(nullable = false)
    private LocalDateTime lastUpdated;

    @Column(nullable = true)
    private String groupName;

    public Standing() {
        this.lastUpdated = LocalDateTime.now();
    }
}
