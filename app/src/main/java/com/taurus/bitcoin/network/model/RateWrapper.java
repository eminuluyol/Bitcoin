package com.taurus.bitcoin.network.model;

import java.util.HashMap;

public class RateWrapper {

    private HashMap<String, Rate> rateHashMap;

    public HashMap<String, Rate> getRateHashMap() {
        return rateHashMap;
    }

    public void setRateHashMap(HashMap<String, Rate> rateHashMap) {
        this.rateHashMap = rateHashMap;
    }

}
