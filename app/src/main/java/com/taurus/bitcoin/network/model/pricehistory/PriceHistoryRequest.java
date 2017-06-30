package com.taurus.bitcoin.network.model.pricehistory;

import com.taurus.bitcoin.network.model.BaseRequest;

public class PriceHistoryRequest extends BaseRequest {

    private String market;
    private String symbol;
    private String period;
    private String format;

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

    public void setPeriod(String period) {
        this.period = period;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getPeriod() {
        return period;
    }

    public String getFormat() {
        return format;
    }
}
