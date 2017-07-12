package com.taurus.bitcoin.pricehistory;

import com.taurus.bitcoin.baseadapter.model.GenericItem;
import com.taurus.bitcoin.core.BaseView;
import java.util.List;

/**
 * Created by eminuluyol on 10/07/2017.
 */

public interface PriceHistoryView extends BaseView {

  void showGetHistorySuccess(List<GenericItem> detailList);
}
