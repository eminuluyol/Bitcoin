package com.taurus.bitcoin.network;

import com.taurus.bitcoin.network.model.currentprice.CurrentPriceRequest;
import com.taurus.bitcoin.network.model.currentprice.RateWrapper;
import com.taurus.bitcoin.network.model.pricehistory.History;
import com.taurus.bitcoin.network.model.pricehistory.PriceHistoryRequest;

import java.util.List;

import io.reactivex.Observable;

public interface BitCoinApi {

    Observable<RateWrapper> getCurrentRates(CurrentPriceRequest request);
    Observable<List<History>> getCurrencyHistorySince(PriceHistoryRequest request);
}
