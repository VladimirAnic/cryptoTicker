package com.ticker.cryptoTicker.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pair")
@SequenceGenerator(name = "pairSeq", allocationSize = 1)
public class Pair implements Serializable {

    private static final long serialVersionUID = 8349227617715553479L;

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "pairName", nullable = false, length = 1)
    private String pairName;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PairArrayValues> pairArrayValues;
//    private int tickerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    //    public int getTickerId() {
//        return tickerId;
//    }
//
//    public void setTickerId(int tickerId) {
//        this.tickerId = tickerId;
//    }
}
