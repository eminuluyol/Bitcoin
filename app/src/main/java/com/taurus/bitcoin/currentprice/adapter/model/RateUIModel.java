package com.taurus.bitcoin.currentprice.adapter.model;

import com.taurus.bitcoin.baseadapter.model.GenericItem;
import com.taurus.bitcoin.network.model.currentprice.Rate;
import com.taurus.bitcoin.util.ListConverter;

import java.util.List;

public class RateUIModel extends GenericItem {

    private String currencyCode;

    private String rate;

    private String name;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
