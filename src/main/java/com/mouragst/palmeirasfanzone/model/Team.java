package com.mouragst.palmeirasfanzone.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "teams")
public class Team {
    
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length=30)
    private String shortName;

    @Column(nullable = false, length=3)
    private String tla;

    @Column(nullable = true)
    private String crest;

    @Column(nullable = false)
    private LocalDateTime lastUpdated;

    public Team() {
        this.lastUpdated = LocalDateTime.now();
    }
}
