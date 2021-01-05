package com.ticker.cryptoTicker.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "PairArrayValues")
@Table(name = "pair_array_values", schema = "public")
public class PairArrayValues implements Serializable {

    private static final long serialVersionUID = 6240756137794169205L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pair_array_values_id_seq")
    @SequenceGenerator(name = "pair_array_values_id_seq", sequenceName = "pair_array_values_id_seq", allocationSize = 1)
    @Column(name = "pair_array_values_id")
    private Long id;

    @Column(name = "fetched_time", nullable = false)
    private Date fetchedTime;

    @Column(name = "first_parameter", nullable = true)
    private BigDecimal firstParameter;

    @Column(name = "second_parameter", nullable = true)
    private BigDecimal secondParameter;

    @Column(name = "third_parameter", nullable = true)
    private BigDecimal thirdParameter;

    @Column(name = "pair_id")
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
