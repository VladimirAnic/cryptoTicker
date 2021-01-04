package com.ticker.cryptoTicker.service.impl;

import com.ticker.cryptoTicker.dao.model.Ticker;
import com.ticker.cryptoTicker.dao.repository.TickerRepository;
import com.ticker.cryptoTicker.service.api.TickerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TickerServiceImpl implements TickerService {

    private TickerRepository tickerRepository;

    @Autowired
    public TickerServiceImpl(TickerRepository tickerRepository) {
        this.tickerRepository = tickerRepository;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(TickerServiceImpl.class);

    @Override
    public List<Ticker> getAllTickers() {

        List<Ticker> tickers = tickerRepository.findAll();

        return tickers;
    }

    @Override
    public List<Ticker> getTickersByPairName(String pairName) {

        List<Ticker> tickers = tickerRepository.getTickersByPairName(pairName);

        return tickers;
    }

//    @Override
//    public List<Ticker> getTickersByPairNameAndDate(Date date, String pairName) {
//
//        List<Ticker> tickers = tickerRepository.getTickersByPairNameAndDate(date, pairName);
//
//        return tickers;
//    }
}
