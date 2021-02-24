package com.ticker.cryptoTicker.service.impl;

import com.ticker.cryptoTicker.model.Ticker;
import com.ticker.cryptoTicker.service.api.TickerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TickerServiceImpl implements TickerService {


    @Override
    public List<Ticker> getAllTickers() {
        return null;
    }

    @Override
    public List<Ticker> getTickersByPairName(String pairName) {
        return null;
    }
}
