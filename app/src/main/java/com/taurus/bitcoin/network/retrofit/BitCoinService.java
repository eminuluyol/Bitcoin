package com.taurus.bitcoin.network.retrofit;

import com.taurus.bitcoin.network.model.currentprice.RateWrapper;
import com.taurus.bitcoin.network.model.pricehistory.History;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BitCoinService {

    @GET("/constants/exchangerates/{market}")
    Observable<RateWrapper> getCurrentRates(@Path("market") String market);

    @GET("/indices/{market}/history/{symbol}")
    Observable<List<History>> getCurrencyHistorySince(
            @Path("market") String market,
            @Path("symbol") String symbol,
            @Query("since") int since
    );
}
