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
    private Long id;

    @Column(name = "ticker_name", nullable = false, length = 50)
    private String tickerName;

    @OneToMany(
            mappedBy = "ticker",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TickerPair> pairs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTickerName() {
        return tickerName;
    }

    public void setTickerName(String tickerName) {
        this.tickerName = tickerName;
    }

    public List<TickerPair> getPairs() {
        return pairs;
    }

    public void setPairs(List<TickerPair> pairs) {
        this.pairs = pairs;
    }
}
