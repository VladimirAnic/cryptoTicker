package com.ticker.cryptoTicker.scheduledTasks;

import com.ticker.cryptoTicker.dao.model.Pair;
import com.ticker.cryptoTicker.dao.model.PairArrayValues;
import com.ticker.cryptoTicker.dao.model.Ticker;
import com.ticker.cryptoTicker.dao.repository.PairArrayValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class TickerDataScheduledTask {

    RestTemplate restTemplate = new RestTemplate();

    @Value("${kraken.ticker.baseUrl}")
    private String baseUrl;
    @Value("${kraken.ticker.pairs}")
    private String pairs;

    @Autowired
    private PairArrayValuesRepository pairArrayValuesRepository;

    private Pair pair = new Pair();

    private Ticker ticker = new Ticker();

    private PairArrayValues pairArrayValues = new PairArrayValues();

    public void getDataFromTicker() {

        WrapperResponseClass response = restTemplate.getForObject(baseUrl + pairs, WrapperResponseClass.class);

//        pairArrayValuesRepository.save(pairArrayValues);
        if (response.getResult().values().iterator().hasNext()) {
            response.getResult().values().iterator().forEachRemaining(
                    tickerInformation ->
                    {
                        pairArrayValues.setFirstParameter(tickerInformation.ask.price);
                        pairArrayValues.setSecondParameter(BigDecimal.valueOf(tickerInformation.ask.wholeLotVolume));
                        pairArrayValues.setThirdParameter(tickerInformation.ask.lotVolume);
                        pairArrayValues.setFetchedTime(new Date());
                        pairArrayValuesRepository.save(pairArrayValues);
                    }
            );
        }
    }

    @Scheduled(cron = "${scheduled.task.job}")
    public void task() {
        getDataFromTicker();
    }


}

