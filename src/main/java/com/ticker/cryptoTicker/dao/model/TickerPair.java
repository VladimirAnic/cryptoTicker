package com.ticker.cryptoTicker.dao.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "TickerPair")
@Table(name = "ticker_pair", schema = "public")
public class TickerPair implements Serializable {

    private static final long serialVersionUID = -3112383011627554243L;

    @EmbeddedId
    private TickerPairId tickerPairId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tickerId")
    private Ticker ticker;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("pairId")
    private Pair pair;

    public TickerPairId getTickerPairId() {
        return tickerPairId;
    }

    public void setTickerPairId(TickerPairId tickerPairId) {
        this.tickerPairId = tickerPairId;
    }

    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }

    public Pair getPair() {
        return pair;
    }

    public void setPair(Pair pair) {
        this.pair = pair;
    }

}
