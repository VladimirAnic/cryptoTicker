package com.ticker.cryptoTicker.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(schema = "public", name = "pair")
public class Pair implements Serializable {

    private static final long serialVersionUID = 8349227617715553479L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pair_id_seq")
    @SequenceGenerator(name = "pair_id_seq", sequenceName = "pair_id_seq", allocationSize = 1)
    @Column(name = "pair_id")
    private Integer id;

    @Column(name = "pair_name", nullable = false, length = 1)
    private String pairName;

//    @Column(name = "ticker_id")
//    private int tickerId;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "pair_array_values_id")
    private List<PairArrayValues> pairArrayValues;


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
