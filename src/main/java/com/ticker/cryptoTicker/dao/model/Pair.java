package com.ticker.cryptoTicker.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Pair")
@Table(name = "pair", schema = "public")
public class Pair implements Serializable {

    private static final long serialVersionUID = 8349227617715553479L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pair_id_seq")
    @SequenceGenerator(name = "pair_id_seq", sequenceName = "pair_id_seq", allocationSize = 1)
    @Column(name = "pair_id")
    private Long id;

    @Column(name = "pair_name", nullable = false, length = 1)
    private String pairName;


    @OneToMany(
            mappedBy = "pair",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TickerPair> tickers = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "pair_array_values_id")
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

    public List<TickerPair> getTickers() {
        return tickers;
    }

    public void setTickers(List<TickerPair> tickers) {
        this.tickers = tickers;
    }

}
