package com.ticker.cryptoTicker.dao.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(schema = "public", name = "ticker")
@Proxy(lazy = false)
public class Ticker implements Serializable {

    private static final long serialVersionUID = 1918364797615635405L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticker_id_seq")
    @SequenceGenerator(name = "ticker_id_seq", sequenceName = "ticker_id_seq", allocationSize = 1)
    @Column(name = "ticker_id")
    private Integer id;

    @Column(name = "ticker_name", nullable = false, length = 50)
    private String tickerName;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "pair_id")
    private List<Pair> pairs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTickerName() {
        return tickerName;
    }

    public void setTickerName(String tickerName) {
        this.tickerName = tickerName;
    }

    public List<Pair> getPairs() {
        return pairs;
    }

    public void setPairs(List<Pair> pairs) {
        this.pairs = pairs;
    }
}
