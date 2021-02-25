package com.ticker.cryptoTicker.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Pair implements Serializable {

    private static final long serialVersionUID = 8349227617715553479L;

    @Id
    @SequenceGenerator(
            name = "pai_sequence",
            sequenceName = "pair_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pair_sequence"
    )
    private Long id;

    private String pairName;

    @ManyToOne
    @JoinColumn(
            name = "ticker_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "ticker_pair_fk"
            )
    )
    private Ticker ticker;


    @OneToMany(
            mappedBy = "pair",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
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
}