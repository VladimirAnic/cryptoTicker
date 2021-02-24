package com.ticker.cryptoTicker.model;


import java.io.Serializable;

public class Ticker implements Serializable {

    private static final long serialVersionUID = 1918364797615635405L;


    private Long id;

    private String tickerName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTickerName() {
        return tickerName;
    }

    public void setTickerName(String tickerName) {
        this.tickerName = tickerName;
    }

}
