package com.ticker.cryptoTicker.model;

import java.io.Serializable;
import java.util.List;

public class Pair implements Serializable {

    private static final long serialVersionUID = 8349227617715553479L;

    private Long id;

    private String pairName;


    private List<PairArrayValues> pairArrayValues;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPairName() {
        return pairName;
    }

    public void setPairName(String pairName) {
        this.pairName = pairName;
    }

    public List<PairArrayValues> getPairArrayValues() {
        return pairArrayValues;
    }

    public void setPairArrayValues(List<PairArrayValues> pairArrayValues) {
        this.pairArrayValues = pairArrayValues;
    }


}
