package com.taurus.bitcoin.currentprice;

import com.taurus.bitcoin.R;
import com.taurus.bitcoin.baseadapter.model.GenericItem;
import com.taurus.bitcoin.core.BasePresenter;
import com.taurus.bitcoin.core.injection.Injector;
import com.taurus.bitcoin.currentprice.adapter.model.RateUIModel;
import com.taurus.bitcoin.network.model.currentprice.CurrentPriceRequest;
import com.taurus.bitcoin.network.model.currentprice.Rate;
import com.taurus.bitcoin.network.model.currentprice.RateWrapper;
import com.taurus.bitcoin.network.model.pricehistory.PriceHistoryRequest;
import com.taurus.bitcoin.pricehistory.adapter.RateHistoryUIModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CurrentPricePresenter extends BasePresenter<CurrentPriceView> {

    private final String MARKET = "local";

    CurrentPricePresenter() {
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

    void onCurrentRatesRequested() {

        CurrentPriceRequest request = new CurrentPriceRequest(MARKET);

        getApi().getCurrentRates(request)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .map(RateWrapper::createList)
            .subscribe(this::handleResponse, this::handleError);

    }

    private void handleResponse(List<RateUIModel> rateUIModels) {

        onProgressBarHide();

        List<GenericItem> data = new ArrayList<>(rateUIModels);
        getView().showGetCurrenRateSuccess(data);

    }

    private void handleError(Throwable throwable) {

        onProgressBarHide();
        getView().showError(throwable.getMessage());

    }

    void onRateHistoryRequested(String currencyCode) {
        getNavigator().toRateHistoryActivity(currencyCode).withAnimation(R.anim.right_in, R.anim.left_out).navigate();
    }
}
