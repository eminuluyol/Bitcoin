package com.taurus.bitcoin.pricehistory.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.TextView;

import com.taurus.bitcoin.R;
import com.taurus.bitcoin.baseadapter.viewholder.BaseViewHolder;

import butterknife.BindView;

public class RateHistoryViewHolder extends BaseViewHolder {


    @BindView(R.id.rateHistoryTextViewTime)
    TextView textViewTime;

    @BindView(R.id.rateHistoryTextViewAverage)
    TextView textViewAverage;

    public RateHistoryViewHolder(@NonNull ViewGroup parentView, int layoutId) {
        super(parentView, layoutId);
    }

    public void bind(RateHistoryUIModel item) {

        textViewAverage.setText(item.getAverage());
        textViewTime.setText(item.getTime());

    }
}
