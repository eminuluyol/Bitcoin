package com.taurus.bitcoin.network;

import com.taurus.bitcoin.network.model.CurrentPriceRequest;
import com.taurus.bitcoin.network.model.RateWrapper;

import io.reactivex.Observable;

public interface BitCoinApi {

    Observable<RateWrapper> getCurrentRates(CurrentPriceRequest request);
}
