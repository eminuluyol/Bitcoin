package com.taurus.bitcoin.currentprice;

import com.taurus.bitcoin.core.BaseView;

public interface CurrentPriceView extends BaseView {

    void showEmptyView();

    void hideEmptyView();
}
