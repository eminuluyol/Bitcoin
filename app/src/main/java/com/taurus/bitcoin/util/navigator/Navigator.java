package com.taurus.bitcoin.util.navigator;

import android.app.Activity;

import com.taurus.bitcoin.network.model.Rate;

import java.util.List;

public class Navigator {

    private final Activity activity;

    public Navigator(Activity activity) {
        this.activity = activity;
    }

    public Navigation toCurrentPriceActivity(List<Rate> rateList) {
        return new Navigation(activity, CurrentPriceActivity.newIntent(activity, rateList));
    }
}
