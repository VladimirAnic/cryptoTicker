package com.ticker.cryptoTicker.dao.repository;

import com.ticker.cryptoTicker.dao.model.Pair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PairRepository extends JpaRepository<Pair, Integer> {
}
