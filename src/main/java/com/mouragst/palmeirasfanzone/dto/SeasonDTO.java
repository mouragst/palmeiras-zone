package com.mouragst.palmeirasfanzone.dto;

public class SeasonDTO {
    private Long id;
    private String startDate;
    private String endDate;
    private String winner;
    private String lastUpdated;

    public SeasonDTO() {
        
    }

    public SeasonDTO(Long id, String startDate, String endDate, String winner) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.winner = winner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
