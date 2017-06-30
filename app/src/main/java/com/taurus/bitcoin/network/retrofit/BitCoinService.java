package com.taurus.bitcoin.network.retrofit;

import com.taurus.bitcoin.network.model.RateWrapper;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BitCoinService {

    @GET("/constants/exchangerates/{market}")
    Observable<RateWrapper> getCurrentRates(@Path("market") String market);
}
