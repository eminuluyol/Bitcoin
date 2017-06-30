package com.taurus.bitcoin.pricehistory.adapter;

import com.taurus.bitcoin.baseadapter.model.GenericItem;
import com.taurus.bitcoin.network.model.pricehistory.History;
import com.taurus.bitcoin.util.ListConverter;

import java.util.List;

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

    public static List<RateHistoryUIModel> createList(List<History> rateHistoryList) {
        return ListConverter.convert(rateHistoryList, item -> create(item));
    }

    private static RateHistoryUIModel create(History item) {

        final RateHistoryUIModel model = new RateHistoryUIModel();

        model.setAverage(String.valueOf(item.getAverage()));
        model.setTime(item.getTime());

        return model;
    }
}
