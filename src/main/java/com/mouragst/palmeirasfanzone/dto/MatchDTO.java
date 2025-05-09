package com.mouragst.palmeirasfanzone.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MatchDTO {
    private String homeTeam;
    private String awayTeam;
    private String competition;
    private LocalDateTime matchDate;
    private Integer homeScore;
    private Integer awayScore;
    private boolean isLive;
}
