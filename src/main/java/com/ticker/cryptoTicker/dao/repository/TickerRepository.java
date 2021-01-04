package com.ticker.cryptoTicker.dao.repository;

import com.ticker.cryptoTicker.dao.model.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TickerRepository extends JpaRepository<Ticker, Long> {


    @Query("SELECT ticker FROM Ticker ticker WHERE ticker.tickerName = :tickerName")
    List<Ticker> getTickersByPairName(String tickerName);
//
//    @Query("SELECT ticker FROM Ticker ticker AND pairArrayValues FROM PairArrayValues pairArrayValues WHERE ticker.tickerName = :tickerName AND pairArrayValues.fetchedTime := fetched_time")
//    List<Ticker> getTickersByPairNameAndDate(Date date, String pairName);
}
