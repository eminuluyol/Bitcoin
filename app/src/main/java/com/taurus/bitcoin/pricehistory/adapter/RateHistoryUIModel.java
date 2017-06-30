package com.taurus.bitcoin.pricehistory.adapter;

import com.taurus.bitcoin.baseadapter.model.GenericItem;

public class RateHistoryUIModel extends GenericItem {

    private String time;
    private String average;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }
}
