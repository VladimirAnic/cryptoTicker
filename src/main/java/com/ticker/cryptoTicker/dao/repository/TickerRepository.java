package com.ticker.cryptoTicker.dao.repository;

import com.ticker.cryptoTicker.dao.model.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TickerRepository extends JpaRepository<Ticker, Long> {
}
