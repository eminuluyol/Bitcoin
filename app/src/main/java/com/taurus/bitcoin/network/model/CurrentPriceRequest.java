package com.taurus.bitcoin.network.model;

public class CurrentPriceRequest extends BaseRequest {

    private String market;

    public CurrentPriceRequest(String market) {
        this.market = market;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }
}
