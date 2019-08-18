package com.ken.apexstats.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ken.apexstats.model.PlayerStatistics;
import com.ken.apexstats.model.PlayerStatisticsDataObj;

@Service
public class StatsService {

    @Value("${api.key}")
    private String APIKEY;

    @Value("${api.url.base}")
    private String URLBASE;

    public PlayerStatistics getStats(final String platform, final String playername) {
        final String url = URLBASE + "/profile/" + platform + "/" + playername;
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("contentType", "application/json");
        headers.add("TRN-Api-Key", APIKEY);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<PlayerStatisticsDataObj> responseEntity = restTemplate.exchange(url, HttpMethod.GET,
                requestEntity, PlayerStatisticsDataObj.class);
        System.out.println(responseEntity.getBody());

        return responseEntity.getBody() != null ? responseEntity.getBody().getData() : null;
    }
}
