package com.mouragst.palmeirasfanzone.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "seasons")
public class Season {

    @Id
    private Long id;

    @Column(nullable = false)
    private String startDate;

    @Column(nullable = false)
    private String endDate;

    @Column(nullable = true)
    private String winner;

    @Column(nullable = true)
    private LocalDate lastUpdated;
    
    public Season() {
        this.lastUpdated = LocalDate.now();
    }
}
