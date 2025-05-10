package com.mouragst.palmeirasfanzone.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

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
    private Date dateOfBirth;

    public Squad() {
        if (this.dateOfBirth != null) {
            LocalDate birthDate = this.dateOfBirth.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            this.age = Period.between(birthDate, LocalDate.now()).getYears();
        } else {
            this.age = null;
        }
    }
}
