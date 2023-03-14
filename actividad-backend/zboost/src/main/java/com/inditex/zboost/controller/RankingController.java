package com.inditex.zboost.controller;

import com.inditex.zboost.entity.Ranking;
import com.inditex.zboost.entity.RankingType;
import com.inditex.zboost.service.RankingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class RankingController {

    private RankingService rankingService;

    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @GetMapping("/ranking")
    public Ranking ranking(@RequestParam(name = "type", required = true) String type, @RequestParam("fromDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fromDate, @RequestParam("toDate")
                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date toDate) {
        RankingType rankingType = RankingType.fromType(type);
        return rankingService.ranking(rankingType, fromDate, toDate);
    }

}
