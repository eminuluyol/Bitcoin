package com.taurus.bitcoin.util.navigator;

import android.app.Activity;

import com.taurus.bitcoin.baseadapter.model.GenericItem;
import com.taurus.bitcoin.currentprice.CurrentPriceActivity;
import com.taurus.bitcoin.network.model.currentprice.Rate;
import com.taurus.bitcoin.pricehistory.PriceHistoryActivity;

import java.util.List;

public class Navigator {

    private final Activity activity;

    public Navigator(Activity activity) {
        this.activity = activity;
    }

    public Navigation toRateHistoryActivity(String currencyCode) {
        return new Navigation(activity, PriceHistoryActivity.newIntent(activity, currencyCode));
    }
}
