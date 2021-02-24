package com.ticker.cryptoTicker.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PairArrayValues implements Serializable {

    private static final long serialVersionUID = 6240756137794169205L;

    private Long id;

    private Date fetchedTime;

    private BigDecimal firstParameter;

    private BigDecimal secondParameter;

    private BigDecimal thirdParameter;

    private int pairId;


    public Date getFetchedTime() {
        return fetchedTime;
    }

    public void setFetchedTime(Date fetchedTime) {
        this.fetchedTime = fetchedTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getFirstParameter() {
        return firstParameter;
    }

    public void setFirstParameter(BigDecimal firstParameter) {
        this.firstParameter = firstParameter;
    }

    public BigDecimal getSecondParameter() {
        return secondParameter;
    }

    public void setSecondParameter(BigDecimal secondParameter) {
        this.secondParameter = secondParameter;
    }

    public BigDecimal getThirdParameter() {
        return thirdParameter;
    }

    public void setThirdParameter(BigDecimal thirdParameter) {
        this.thirdParameter = thirdParameter;
    }

    public int getPairId() {
        return pairId;
    }

    public void setPairId(int pairId) {
        this.pairId = pairId;
    }

    @Override
    public String toString() {
        return "PairArrayValues{" +
                "id=" + id +
                ", fetchedTime=" + fetchedTime +
                ", firstParameter=" + firstParameter +
                ", secondParameter=" + secondParameter +
                ", thirdParameter=" + thirdParameter +
                ", pairId=" + pairId +
                '}';
    }
}
