package com.ticker.cryptoTicker.dao;

import com.ticker.cryptoTicker.model.Pair;

import java.util.Random;

public interface PairDao {

    Long insertPair(Long id, Pair pair);

    default Long addPair(Pair pair) {
        Long id = new Random().nextLong();
        return insertPair(id, pair);
    }
}
