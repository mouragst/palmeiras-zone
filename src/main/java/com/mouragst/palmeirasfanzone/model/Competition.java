package com.mouragst.palmeirasfanzone.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "competitions")
public class Competition {

    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, length=8)
    private String code;

    @Column(nullable = false, length=10)
    private String type;

    @Column(nullable = true)
    private String emblem;

    @Column(nullable = false)
    private LocalDateTime lastUpdated;
    
    public Competition() {
        this.lastUpdated = LocalDateTime.now();
    }
}
