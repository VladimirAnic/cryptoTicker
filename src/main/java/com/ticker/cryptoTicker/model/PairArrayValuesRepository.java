package com.ticker.cryptoTicker.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PairArrayValuesRepository extends JpaRepository<PairArrayValues, Long> {
}
