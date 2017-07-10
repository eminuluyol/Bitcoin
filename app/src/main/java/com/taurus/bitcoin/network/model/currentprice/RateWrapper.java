package com.taurus.bitcoin.network.model.currentprice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.taurus.bitcoin.currentprice.adapter.model.RateUIModel;
import com.taurus.bitcoin.util.ListConverter;
import java.util.List;

public class RateWrapper {

    @SerializedName("time")
    @Expose
    private String time;

    @SerializedName("rates")
    @Expose
    private Rate rate;

    private List<Rate> rateList;

    public RateWrapper(List<Rate> rateList) {
        this.rateList = rateList;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rates) {
        this.rate = rates;
    }

    public List<Rate> getRateList() {
        return rateList;
    }

    public static List<RateUIModel> createList(RateWrapper rateWrapper) {
        return ListConverter.convert(rateWrapper.getRateList(), item -> create(item));
    }

    private static RateUIModel create(Rate item) {

        final RateUIModel model = new RateUIModel();

        model.setCurrencyCode(item.getCurrencyCode());
        model.setName(item.getName());
        model.setRate(item.getRate());

        return model;
    }

}
