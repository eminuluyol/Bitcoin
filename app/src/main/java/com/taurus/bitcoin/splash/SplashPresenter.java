package com.taurus.bitcoin.splash;

import android.util.Log;

import com.taurus.bitcoin.core.BasePresenter;
import com.taurus.bitcoin.core.injection.Injector;
import com.taurus.bitcoin.network.model.BaseRequest;
import com.taurus.bitcoin.network.model.Rate;
import com.taurus.bitcoin.network.model.RateWrapper;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SplashPresenter extends BasePresenter<SplashView> {

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

        BaseRequest request = new BaseRequest();

        getApi().getCurrentRates(request)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError);

    }

    private void handleResponse(RateWrapper rateWrapper) {

        onProgressBarHide();

        List<Rate> rateList = rateWrapper.getRateList();

        Log.i("Size", " " + rateList.size());


    }

    private void handleError(Throwable throwable) {

    }
}
