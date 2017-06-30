package com.taurus.bitcoin.core;

import android.app.Application;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.taurus.bitcoin.network.BitCoinApi;
import com.taurus.bitcoin.util.navigator.Navigator;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<V extends BaseView> extends MvpBasePresenter<V> {

    @Inject
    Application application;

    @Inject
    BitCoinApi api;

    @Inject
    Navigator navigator;

    protected CompositeDisposable compositeDisposable;

    public BasePresenter(){
        compositeDisposable = new CompositeDisposable();
    }

    public Application getApplication() {
        return application;
    }

    public BitCoinApi getApi() {
        return api;
    }

    public Navigator getNavigator() {
        return navigator;
    }

    public void clearCompositeDisposable() {

        if (compositeDisposable != null) {

            compositeDisposable.clear();
        }
    }

}