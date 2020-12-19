package com.ticker.cryptoTicker.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pairArrayValues")
@SequenceGenerator(name = "pairArrayValuesSeq", allocationSize = 1)
public class PairArrayValues implements Serializable {

    private static final long serialVersionUID = 6240756137794169205L;

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "fetchedTime", nullable = false)
    private Date fetchedTime;

    @Column(name = "firstParameter", nullable = true)
    private float firstParameter;

    @Column(name = "secondParameter", nullable = true)
    private float secondParameter;

    @Column(name = "thirdParameter", nullable = true)
    private float thirdParameter;

    private int pairId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFetchedTime() {
        return fetchedTime;
    }

    public void setFetchedTime(Date fetchedTime) {
        this.fetchedTime = fetchedTime;
    }

    public float getFirstParameter() {
        return firstParameter;
    }

    public void setFirstParameter(float firstParameter) {
        this.firstParameter = firstParameter;
    }

    public float getSecondParameter() {
        return secondParameter;
    }

    public void setSecondParameter(float secondParameter) {
        this.secondParameter = secondParameter;
    }

    public float getThirdParameter() {
        return thirdParameter;
    }

    public void setThirdParameter(float thirdParameter) {
        this.thirdParameter = thirdParameter;
    }

    public int getPairId() {
        return pairId;
    }

    public void setPairId(int pairId) {
        this.pairId = pairId;
    }
}
