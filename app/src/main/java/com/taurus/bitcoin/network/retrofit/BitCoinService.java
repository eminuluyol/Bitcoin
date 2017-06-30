package com.taurus.bitcoin.network.retrofit;

import com.taurus.bitcoin.network.model.RateWrapper;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface BitCoinService {

    @GET("/constants/exchangerates/local")
    Observable<RateWrapper> getCurrentRates();
}
