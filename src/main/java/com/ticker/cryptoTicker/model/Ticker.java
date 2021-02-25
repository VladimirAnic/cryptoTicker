package com.ticker.cryptoTicker.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Ticker implements Serializable {

    private static final long serialVersionUID = 1918364797615635405L;

    @Id
    @SequenceGenerator(
            name = "ticker_sequence",
            sequenceName = "ticker_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ticker_sequence"
    )
    private Long id;

    private String tickerName;


    @OneToMany(
            mappedBy = "ticker",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Pair> pairs = new ArrayList<>();

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

}
