package com.ticker.cryptoTicker.dao.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TickerPairId implements Serializable {
    //https://vladmihalcea.com/the-best-way-to-map-a-many-to-many-association-with-extra-columns-when-using-jpa-and-hibernate/
    private static final long serialVersionUID = -8866335696037067549L;

    @Column(name = "pair_id")
    private Long pairId;

    @Column(name = "ticker_id")
    private Long tickerId;

    public Long getPairId() {
        return pairId;
    }

    public void setPairId(Long pairId) {
        this.pairId = pairId;
    }

    public Long getTickerId() {
        return tickerId;
    }

    public void setTickerId(Long tickerId) {
        this.tickerId = tickerId;
    }
}
