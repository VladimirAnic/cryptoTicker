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

//    @Query(
//            "SELECT ticker FROM Ticker ticker " +
//                    "LEFT OUTER JOIN TickerPair ticker_pair ON ticker.ticker_id = ticker_pair.ticker_id " +
//                    "LEFT OUTER JOIN Pair pair ON pair.pair_id = ticker_pair.pair_id " +
//                    "LEFT OUTER JOIN PairArrayValues pair_array_values ON pair.pair_id = pair_array_values.pair_id " +
//                    "WHERE ticker.ticker_name = :pairName " +
//                    "AND pair_array_values.fetched_time = :date"
//    )
//    List<Ticker> getTickersByPairNameAndDate(Date date, String pairName);
}
