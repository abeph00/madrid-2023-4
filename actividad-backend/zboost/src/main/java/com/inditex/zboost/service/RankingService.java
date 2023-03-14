package com.inditex.zboost.service;

import com.inditex.zboost.entity.Ranking;
import com.inditex.zboost.entity.RankingType;

import java.util.Date;

public interface RankingService {

    Ranking ranking(RankingType rankingType, Date fromDate, Date toDate);

}
