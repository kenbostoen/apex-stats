package com.ken.apexstats.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ken.apexstats.model.PlayerStatistics;
import com.ken.apexstats.services.StatsService;


@RestController
public class StatsController {

    private final StatsService statsService;

    public StatsController(final StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping(value = "/player/stats/{playername}")
    public PlayerStatistics getStatsForPlayer(@PathVariable("playername") String playername) {
        return statsService.getStats(playername);
    }

}
