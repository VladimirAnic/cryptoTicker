package com.ticker.cryptoTicker.dao.repository;

import com.ticker.cryptoTicker.dao.model.PairArrayValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PairArrayValuesRepository extends JpaRepository<PairArrayValues, Integer> {
}
