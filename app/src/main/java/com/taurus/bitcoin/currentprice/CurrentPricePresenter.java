package com.taurus.bitcoin.currentprice;

import com.taurus.bitcoin.R;
import com.taurus.bitcoin.baseadapter.model.GenericItem;
import com.taurus.bitcoin.core.BasePresenter;
import com.taurus.bitcoin.core.injection.Injector;
import com.taurus.bitcoin.currentprice.adapter.model.RateUIModel;
import com.taurus.bitcoin.network.model.pricehistory.PriceHistoryRequest;
import com.taurus.bitcoin.pricehistory.adapter.RateHistoryUIModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CurrentPricePresenter extends BasePresenter<CurrentPriceView> {

    CurrentPricePresenter() {
        Injector.getInstance().getActivityComponent().inject(this);
    }

    void onRateHistoryRequested(RateUIModel rateUIModel) {

        getView().showProgress();

        PriceHistoryRequest request = new PriceHistoryRequest();

        request.setMarket("local");
        request.setSymbol("BTC" + rateUIModel.getCurrencyCode());

//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.MONTH, -1);
//        Long timestamp = cal.getTimeInMillis();
//
//        request.setTimestamp(timestamp);
        request.setPeriod("daily");
        request.setFormat("json");

        getApi().getCurrencyHistorySince(request)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(RateHistoryUIModel::createList)
                .subscribe(this::handleResponse, this::handleError);



    }

    private void handleResponse(List<RateHistoryUIModel> rateHistoryUIModels) {

        if(isViewAttached()) {

            getView().dismissProgress();

        }

        if(rateHistoryUIModels.size() > 0) {

            List<GenericItem> detailList = new ArrayList<>(rateHistoryUIModels);

            getNavigator().toRateHistoryActivity(detailList).withAnimation(R.anim.right_in, R.anim.left_out).navigate();

        }

    }

    private void handleError(Throwable throwable) {

        if(isViewAttached()) {

            getView().dismissProgress();

        }

    }
}
