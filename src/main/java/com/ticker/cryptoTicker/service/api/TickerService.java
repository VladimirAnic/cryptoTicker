package com.ticker.cryptoTicker.service.api;

import com.ticker.cryptoTicker.dao.model.Ticker;

import java.util.List;

public interface TickerService {

    List<Ticker> getAllTickers();

    List<Ticker> getTickersByPairName(String pairName);

//    List<Ticker> getTickersByPairNameAndDate(Date date, String pairName);
}
