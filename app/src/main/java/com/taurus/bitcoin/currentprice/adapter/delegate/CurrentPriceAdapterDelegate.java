package com.taurus.bitcoin.currentprice.adapter.delegate;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.taurus.bitcoin.R;
import com.taurus.bitcoin.baseadapter.BaseAdapterDelegate;
import com.taurus.bitcoin.baseadapter.model.GenericItem;
import com.taurus.bitcoin.currentprice.adapter.viewholder.CurrentPriceViewHolder;
import com.taurus.bitcoin.currentprice.adapter.model.RateUIModel;
import com.taurus.bitcoin.listener.OnItemClickListener;

import java.util.List;

public class CurrentPriceAdapterDelegate extends BaseAdapterDelegate<RateUIModel, GenericItem,
        CurrentPriceViewHolder> {

    public CurrentPriceAdapterDelegate(OnItemClickListener callback) {
        setOnItemClickListener(callback);
    }

    @Override
    protected boolean isForViewType(@NonNull GenericItem item, @NonNull List<GenericItem> items, int position) {
        return item instanceof RateUIModel;
    }

    @NonNull
    @Override
    protected CurrentPriceViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new CurrentPriceViewHolder(parent, R.layout.list_item_current_price, getOnItemClickListener());
    }

    @Override
    protected void onBindViewHolder(@NonNull RateUIModel item, @NonNull CurrentPriceViewHolder viewHolder, @NonNull List<Object> payloads) {
        viewHolder.bind(item);
    }

}
