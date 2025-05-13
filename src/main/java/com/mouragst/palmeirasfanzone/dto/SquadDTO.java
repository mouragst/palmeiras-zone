package com.mouragst.palmeirasfanzone.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SquadDTO {

    private Long id;
    private String name;
    private String position;
    private Integer age;
    private String nationality;
    private LocalDate dateOfBirth;
    private LocalDateTime lastUpdated;

    public SquadDTO() {
    }

    public SquadDTO(Long id, String name, String position, Integer age, 
                    String nationality, LocalDate dateOfBirth, LocalDateTime lastUpdated) 
    {
        this.id = id;
        this.name = name;
        this.position = position;
        this.age = age;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.lastUpdated = lastUpdated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
