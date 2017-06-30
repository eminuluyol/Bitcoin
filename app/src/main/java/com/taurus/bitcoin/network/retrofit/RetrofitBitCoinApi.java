package com.taurus.bitcoin.network.retrofit;

import com.taurus.bitcoin.network.BitCoinApi;
import com.taurus.bitcoin.network.model.BaseRequest;
import com.taurus.bitcoin.network.model.RateWrapper;

import io.reactivex.Observable;

public class RetrofitBitCoinApi implements BitCoinApi {

    public RetrofitBitCoinApi() {
    }

    @Override
    public Observable<RateWrapper> getCurrentRates(BaseRequest request) {
        return null;
    }
}
