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
    private String firstParameter;

    @Column(name = "secondParameter", nullable = true)
    private String secondParameter;

    @Column(name = "thirdParameter", nullable = true)
    private String thirdParameter;

    private int pairId;


    public Date getFetchedTime() {
        return fetchedTime;
    }

    public void setFetchedTime(Date fetchedTime) {
        this.fetchedTime = fetchedTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstParameter() {
        return firstParameter;
    }

    public void setFirstParameter(String firstParameter) {
        this.firstParameter = firstParameter;
    }

    public String getSecondParameter() {
        return secondParameter;
    }

    public void setSecondParameter(String secondParameter) {
        this.secondParameter = secondParameter;
    }

    public String getThirdParameter() {
        return thirdParameter;
    }

    public void setThirdParameter(String thirdParameter) {
        this.thirdParameter = thirdParameter;
    }

    public int getPairId() {
        return pairId;
    }

    public void setPairId(int pairId) {
        this.pairId = pairId;
    }
}
