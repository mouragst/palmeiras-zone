package com.mouragst.palmeirasfanzone.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "squad")
public class Squad {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "age")
    private Integer age;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private LocalDateTime lastUpdated;

    public Squad() {
        this.lastUpdated = LocalDateTime.now();
    }
}
