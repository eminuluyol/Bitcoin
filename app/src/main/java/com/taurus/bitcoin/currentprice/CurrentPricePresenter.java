package com.taurus.bitcoin.currentprice;

import com.taurus.bitcoin.core.BasePresenter;
import com.taurus.bitcoin.core.injection.Injector;

public class CurrentPricePresenter extends BasePresenter<CurrentPriceView> {

    CurrentPricePresenter() {
        Injector.getInstance().getActivityComponent().inject(this);
    }
}
