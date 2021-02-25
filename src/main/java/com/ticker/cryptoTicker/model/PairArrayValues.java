package com.ticker.cryptoTicker.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table
public class PairArrayValues implements Serializable {

    private static final long serialVersionUID = 6240756137794169205L;

    @Id
    @SequenceGenerator(
            name = "pair_array_values_sequence",
            sequenceName = "pair_array_values_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pair_array_values_sequence"
    )
    private Long id;

    private Date fetchedTime;

    private BigDecimal firstParameter;

    private BigDecimal secondParameter;

    private BigDecimal thirdParameter;

//    private int pairId;

    @ManyToOne
    @JoinColumn(
            name = "pair_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "pair_pair_array_values_fk"
            )
    )
    private Pair pair;

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

//    public int getPairId() {
//        return pairId;
//    }
//
//    public void setPairId(int pairId) {
//        this.pairId = pairId;
//    }


    public Pair getPair() {
        return pair;
    }

    public void setPair(Pair pair) {
        this.pair = pair;
    }

    @Override
    public String toString() {
        return "PairArrayValues{" +
                "id=" + id +
                ", fetchedTime=" + fetchedTime +
                ", firstParameter=" + firstParameter +
                ", secondParameter=" + secondParameter +
                ", thirdParameter=" + thirdParameter +
                ", pair=" + pair +
                '}';
    }
}
