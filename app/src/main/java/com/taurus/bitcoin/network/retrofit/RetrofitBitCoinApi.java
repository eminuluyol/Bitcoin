package com.taurus.bitcoin.network.retrofit;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.taurus.bitcoin.network.BitCoinApi;
import com.taurus.bitcoin.network.model.currentprice.CurrentPriceRequest;
import com.taurus.bitcoin.network.model.currentprice.Rate;
import com.taurus.bitcoin.network.model.currentprice.RateWrapper;
import com.taurus.bitcoin.network.model.pricehistory.History;
import com.taurus.bitcoin.network.model.pricehistory.PriceHistoryRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.reactivex.Observable;

public class RetrofitBitCoinApi implements BitCoinApi {

    public RetrofitBitCoinApi() {
    }

    @Override
    public Observable<RateWrapper> getCurrentRates(CurrentPriceRequest currentPriceRequest) {

        final Type typeRateWrapper = new TypeToken<RateWrapper>() {
        }.getType();

        JsonDeserializer<RateWrapper> deserializer = (json, typeOfT, context) -> {

            List<Rate> rateList = new ArrayList<>();
            Rate rate = new Rate();

            JsonObject jsonRoot = json.getAsJsonObject();

            JsonObject rates = jsonRoot.get("rates").getAsJsonObject();

            if (rates != null) {
                Set<Map.Entry<String, JsonElement>> entries = rates.entrySet();
                for (Map.Entry<String, JsonElement> entry : entries) {

                    String currencyCode = entry.getKey();
                    // String name = entry.getValue().

                    rate = new Gson().fromJson(entry.getValue().toString(), Rate.class);
                    rate.setCurrencyCode(currencyCode);
                    rateList.add(rate);
                }

            }

            return new RateWrapper(rateList);
        };

        // init gson parser
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        gsonBuilder.registerTypeAdapter(typeRateWrapper, deserializer);
        Gson gson = gsonBuilder.create();


        BitCoinService endpoints = APIRestClient.getInstanceRx(gson).create(BitCoinService.class);

        return endpoints.getCurrentRates(currentPriceRequest.getMarket());
    }

    @Override
    public Observable<List<History>> getCurrencyHistorySince(PriceHistoryRequest request) {

        BitCoinService endpoints = APIRestClient.getInstanceRx().create(BitCoinService.class);
        return endpoints.getCurrencyHistorySince(request.getMarket(), request.getSymbol(),
                request.getPeriod(), request.getFormat());
    }
}
