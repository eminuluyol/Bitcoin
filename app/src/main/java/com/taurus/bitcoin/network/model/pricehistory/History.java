package com.taurus.bitcoin.network.model.pricehistory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class History {

    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("average")
    @Expose
    private double average;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

}
