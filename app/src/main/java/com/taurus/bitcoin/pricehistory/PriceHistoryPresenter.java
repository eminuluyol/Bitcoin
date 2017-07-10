package com.taurus.bitcoin.pricehistory;

import com.taurus.bitcoin.R;
import com.taurus.bitcoin.baseadapter.model.GenericItem;
import com.taurus.bitcoin.core.BasePresenter;
import com.taurus.bitcoin.core.injection.Injector;
import com.taurus.bitcoin.network.model.pricehistory.PriceHistoryRequest;
import com.taurus.bitcoin.pricehistory.adapter.RateHistoryUIModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eminuluyol on 10/07/2017.
 */

public class PriceHistoryPresenter extends BasePresenter<PriceHistoryView> {

  PriceHistoryPresenter() {
    Injector.getInstance().getActivityComponent().inject(this);
  }

  void onProgressBarShow() {

    if(isViewAttached()) {

      getView().showProgress();
    }
  }

  void onProgressBarHide() {

    if(isViewAttached()) {

      getView().dismissProgress();
    }
  }

  void onRateHistoryRequested(String currencyCode) {

    getView().showProgress();

    PriceHistoryRequest request = new PriceHistoryRequest();

    request.setMarket("local");
    request.setSymbol("BTC" + currencyCode);

    //        Calendar cal = Calendar.getInstance();
    //        cal.add(Calendar.MONTH, -1);
    //        Long timestamp = cal.getTimeInMillis();
    //
    //        request.setTimestamp(timestamp);
    request.setPeriod("daily");
    request.setFormat("json");

    getApi().getCurrencyHistorySince(request)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .map(RateHistoryUIModel::createList)
            .subscribe(this::handleResponse, this::handleError);

  }

  private void handleResponse(List<RateHistoryUIModel> rateHistoryUIModels) {

      if(isViewAttached()) {

          getView().dismissProgress();

      }

      if(rateHistoryUIModels.size() > 0) {

         List<GenericItem> detailList = new ArrayList<>(rateHistoryUIModels);
         getView().showGetHistorySuccess(detailList);
      }

  }

  private void handleError(Throwable throwable) {

      if(isViewAttached()) {

          getView().dismissProgress();

      }

  }

}
