package com.mouragst.palmeirasfanzone.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

@Service
public class FootballDataService {
    
    @Value("${football.api.key}")
    private String apiKey;
    
    private final RestTemplate restTemplate;

    public FootballDataService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getMatches() {
        String url = "https://api.football-data.org/v4/teams/1769/matches";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Auth-Token", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, org.springframework.http.HttpMethod.GET, entity, String.class);

        return response.getBody();
    }
}
