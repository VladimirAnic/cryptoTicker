package com.ticker.cryptoTicker.scheduledTasks;

import com.ticker.cryptoTicker.dao.model.Pair;
import com.ticker.cryptoTicker.dao.model.PairArrayValues;
import com.ticker.cryptoTicker.dao.model.Ticker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TickerDataScheduledTask {

    RestTemplate restTemplate = new RestTemplate();

    @Value("${kraken.ticker.baseUrl}")
    private String baseUrl;
    @Value("${kraken.ticker.pairs}")
    private String pairs;

    private Pair pair = new Pair();

    private Ticker ticker = new Ticker();

    private PairArrayValues pairArrayValues = new PairArrayValues();

    public void getDataFromTicker() {

        Object response = restTemplate.getForObject(baseUrl + pairs, Object.class);

        System.out.println(response.toString());
    }

    @Scheduled(cron = "${scheduled.task.job}")
    public void task() {
        getDataFromTicker();
    }


}

