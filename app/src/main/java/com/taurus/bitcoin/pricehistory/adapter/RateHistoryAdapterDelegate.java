package com.taurus.bitcoin.pricehistory.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.taurus.bitcoin.R;
import com.taurus.bitcoin.baseadapter.BaseAdapterDelegate;
import com.taurus.bitcoin.baseadapter.model.GenericItem;

import java.util.List;

public class RateHistoryAdapterDelegate extends BaseAdapterDelegate<RateHistoryUIModel, GenericItem,
        RateHistoryViewHolder> {

    @Override
    protected boolean isForViewType(@NonNull GenericItem item, @NonNull List<GenericItem> items, int position) {
        return item instanceof RateHistoryUIModel;
    }

    @NonNull
    @Override
    protected RateHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new RateHistoryViewHolder(parent, R.layout.list_rate_history);
    }

    @Override
    protected void onBindViewHolder(@NonNull RateHistoryUIModel item, @NonNull RateHistoryViewHolder viewHolder, @NonNull List<Object> payloads) {
        viewHolder.bind(item);
    }
}
