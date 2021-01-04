package com.ticker.cryptoTicker.scheduledTasks;

import com.ticker.cryptoTicker.dao.model.Pair;
import com.ticker.cryptoTicker.dao.model.PairArrayValues;
import com.ticker.cryptoTicker.dao.model.Ticker;
import com.ticker.cryptoTicker.dao.repository.PairArrayValuesRepository;
import com.ticker.cryptoTicker.dao.repository.TickerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class TickerDataScheduledTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(TickerDataScheduledTask.class);

    RestTemplate restTemplate = new RestTemplate();

    @Value("${kraken.ticker.baseUrl}")
    private String baseUrl;
    @Value("${kraken.ticker.pairs}")
    private String pairs;

    String a = null;

    @Autowired
    private PairArrayValuesRepository pairArrayValuesRepository;

    @Autowired
    private TickerRepository tickerRepository;

    private Pair pair = new Pair();

    private Ticker ticker = new Ticker();


    private PairArrayValues pairArrayValues = new PairArrayValues();

    public void getDataFromTicker() {

        WrapperResponseClass response = restTemplate.getForObject(baseUrl + pairs, WrapperResponseClass.class);
        if (response.getResult().values().iterator().hasNext()) {

            //get ticker names and check if it already exists in db
            response.getResult().keySet().iterator().forEachRemaining(
                    s ->
                    {

                        tickerRepository.findAll().iterator().forEachRemaining(
                                ticker1 -> {
                                    if (!ticker1.getTickerName().equals(s)) {
                                        ticker.setTickerName(s);
                                        tickerRepository.save(ticker);
                                    }
                                }
                        );
                    }
            );

            response.getResult().values().iterator().forEachRemaining(
                    tickerInformation ->
                    {
                        System.out.println(tickerInformation.toString());
                        pairArrayValues.setFirstParameter(tickerInformation.ask.price);
                        pairArrayValues.setSecondParameter(BigDecimal.valueOf(tickerInformation.ask.wholeLotVolume));
                        pairArrayValues.setThirdParameter(tickerInformation.ask.lotVolume);
                        pairArrayValues.setPairId(0);
                        pairArrayValues.setFetchedTime(new Date());
                        pairArrayValuesRepository.save(pairArrayValues);
                        pairArrayValuesRepository.flush();

                        pairArrayValues.setFirstParameter(tickerInformation.bid.price);
                        pairArrayValues.setSecondParameter(BigDecimal.valueOf(tickerInformation.bid.wholeLotVolume));
                        pairArrayValues.setThirdParameter(tickerInformation.bid.lotVolume);
                        pairArrayValues.setFetchedTime(new Date());
                        pairArrayValues.setPairId(1);
                        pairArrayValuesRepository.save(pairArrayValues);
                        pairArrayValuesRepository.flush();

                        pairArrayValues.setFirstParameter(tickerInformation.lastTradeClosed.price);
                        pairArrayValues.setThirdParameter(tickerInformation.lastTradeClosed.lotVolume);
                        pairArrayValues.setFetchedTime(new Date());
                        pairArrayValues.setPairId(2);
                        pairArrayValuesRepository.save(pairArrayValues);
                        pairArrayValuesRepository.flush();

                        pairArrayValues.setFirstParameter(tickerInformation.volume.today);
                        pairArrayValues.setSecondParameter(tickerInformation.volume.last24hours);
                        pairArrayValues.setFetchedTime(new Date());
                        pairArrayValues.setPairId(3);
                        pairArrayValuesRepository.save(pairArrayValues);
                        pairArrayValuesRepository.flush();

                        pairArrayValues.setFirstParameter(tickerInformation.volumeWeightAverage.today);
                        pairArrayValues.setSecondParameter(tickerInformation.volumeWeightAverage.last24hours);
                        pairArrayValues.setFetchedTime(new Date());
                        pairArrayValues.setPairId(4);
                        pairArrayValuesRepository.save(pairArrayValues);
                        pairArrayValuesRepository.flush();

                        pairArrayValues.setFirstParameter(BigDecimal.valueOf(tickerInformation.numberOfTrades.today));
                        pairArrayValues.setSecondParameter(BigDecimal.valueOf(tickerInformation.numberOfTrades.last24hours));
                        pairArrayValues.setFetchedTime(new Date());
                        pairArrayValues.setPairId(5);
                        pairArrayValuesRepository.save(pairArrayValues);
                        pairArrayValuesRepository.flush();

                        pairArrayValues.setFirstParameter(tickerInformation.low.today);
                        pairArrayValues.setSecondParameter(tickerInformation.low.last24hours);
                        pairArrayValues.setFetchedTime(new Date());
                        pairArrayValues.setPairId(6);
                        pairArrayValuesRepository.save(pairArrayValues);
                        pairArrayValuesRepository.flush();

                        pairArrayValues.setFirstParameter(tickerInformation.high.today);
                        pairArrayValues.setSecondParameter(tickerInformation.high.last24hours);
                        pairArrayValues.setFetchedTime(new Date());
                        pairArrayValues.setPairId(7);
                        pairArrayValuesRepository.save(pairArrayValues);
                        pairArrayValuesRepository.flush();

                        pairArrayValues.setFirstParameter(tickerInformation.todayOpenPrice);
                        pairArrayValues.setPairId(8);
                        pairArrayValuesRepository.save(pairArrayValues);
                        pairArrayValuesRepository.flush();

                        System.out.println(pairArrayValues.toString());
                    }
            );
        }
    }

    @Scheduled(cron = "${scheduled.task.job}")
    public void task() {
        getDataFromTicker();
    }


}

