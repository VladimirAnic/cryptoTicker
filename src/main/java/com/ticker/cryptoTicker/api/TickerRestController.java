package com.ticker.cryptoTicker.api;

import com.ticker.cryptoTicker.model.Ticker;
import com.ticker.cryptoTicker.service.api.TickerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tickers")
public class TickerRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TickerRestController.class);

    private final TickerService tickerService;

    @Autowired
    public TickerRestController(TickerService tickerService) {
        this.tickerService = tickerService;
    }

    @GetMapping("")
    public List<Ticker> getAllTickers() {
        List<Ticker> tickers = tickerService.getAllTickers();
        return tickers;
    }

    @GetMapping("/{pairName}")
    public List<Ticker> getTickersByPairName(@PathVariable String pairName) {
        List<Ticker> tickers = tickerService.getTickersByPairName(pairName);
        return tickers;
    }

//    @GetMapping("/{date}/{pairName}")
//    public List<Ticker> getTickersByPairNameAndDate(@PathVariable Date date, @PathVariable String pairName) {
//        List<Ticker> tickers = tickerService.getTickersByPairNameAndDate(date, pairName);
//        return tickers;
//    }
}
