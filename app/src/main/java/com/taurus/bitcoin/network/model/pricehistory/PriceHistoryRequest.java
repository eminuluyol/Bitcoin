package com.taurus.bitcoin.network.model.pricehistory;

import com.taurus.bitcoin.network.model.BaseRequest;

public class PriceHistoryRequest extends BaseRequest {

    private String market;
    private String symbol;
    private int timestamp;

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}
