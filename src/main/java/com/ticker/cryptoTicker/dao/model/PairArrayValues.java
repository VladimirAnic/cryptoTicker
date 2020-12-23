package com.ticker.cryptoTicker.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "pair_array_values")
@SequenceGenerator(name = "pairArrayValuesSeq", allocationSize = 1)
public class PairArrayValues implements Serializable {

    private static final long serialVersionUID = 6240756137794169205L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fetched_Time", nullable = false)
    private Date fetchedTime;

    @Column(name = "first_Parameter", nullable = true)
    private BigDecimal firstParameter;

    @Column(name = "second_Parameter", nullable = true)
    private BigDecimal secondParameter;

    @Column(name = "third_Parameter", nullable = true)
    private BigDecimal thirdParameter;

    @Column(name = "pair_Id")
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
}
