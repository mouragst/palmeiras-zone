package com.mouragst.palmeirasfanzone.dto;

public class CompetitionDTO {
    private Long id;
    private String name;
    private String code;
    private String type;
    private String emblem;
    private String lastUpdated;

    public CompetitionDTO() {
    }

    public CompetitionDTO(Long id, String name, String code, String type, String emblem) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.type = type;
        this.emblem = emblem;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmblem() {
        return emblem;
    }

    public void setEmblem(String emblem) {
        this.emblem = emblem;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
