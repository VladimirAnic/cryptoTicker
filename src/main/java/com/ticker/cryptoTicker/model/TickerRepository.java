package com.ticker.cryptoTicker.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TickerRepository extends CrudRepository<Ticker, Long> {
}
