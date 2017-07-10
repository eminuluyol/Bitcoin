package com.taurus.bitcoin.currentprice;

import com.taurus.bitcoin.baseadapter.model.GenericItem;
import com.taurus.bitcoin.core.BaseView;
import java.util.List;

public interface CurrentPriceView extends BaseView {

    void showEmptyView();

    void hideEmptyView();

  void showGetCurrenRateSuccess(List<GenericItem> data);
}
