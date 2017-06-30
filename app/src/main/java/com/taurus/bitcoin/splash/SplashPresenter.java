package com.taurus.bitcoin.splash;

import com.taurus.bitcoin.core.BasePresenter;
import com.taurus.bitcoin.core.injection.Injector;
import com.taurus.bitcoin.network.model.currentprice.CurrentPriceRequest;
import com.taurus.bitcoin.network.model.currentprice.Rate;
import com.taurus.bitcoin.network.model.currentprice.RateWrapper;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SplashPresenter extends BasePresenter<SplashView> {

    private final String MARKET = "local";

    SplashPresenter() {
        Injector.getInstance().getActivityComponent().inject(this);
    }

    void onProgressBarShow() {

        if(isViewAttached()) {

            getView().showLoading();
        }
    }

    void onProgressBarHide() {

        if(isViewAttached()) {

            getView().hideLoading();
        }
    }

    void onCurrentRatesRequested() {

        CurrentPriceRequest request = new CurrentPriceRequest(MARKET);

        getApi().getCurrentRates(request)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError);

    }

    private void handleResponse(RateWrapper rateWrapper) {

        onProgressBarHide();

        List<Rate> rateList = rateWrapper.getRateList();
        onCurrentPriceActivityRequested(rateList);

    }

    private void onCurrentPriceActivityRequested(List<Rate> rateList) {
        getNavigator().toCurrentPriceActivity(rateList).clearBackStack().navigate();
    }

    private void handleError(Throwable throwable) {

        onProgressBarHide();
        getView().showError(throwable.getMessage());

    }
}
