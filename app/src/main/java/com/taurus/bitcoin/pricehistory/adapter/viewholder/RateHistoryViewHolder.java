package com.taurus.bitcoin.pricehistory.adapter.viewholder;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.TextView;

import com.taurus.bitcoin.R;
import com.taurus.bitcoin.baseadapter.viewholder.BaseViewHolder;

import butterknife.BindView;
import com.taurus.bitcoin.pricehistory.adapter.model.RateHistoryUIModel;

public class RateHistoryViewHolder extends BaseViewHolder {


    @BindView(R.id.rateHistoryTextViewTime)
    TextView textViewTime;

    @BindView(R.id.rateHistoryTextViewAverage)
    TextView textViewAverage;

    public RateHistoryViewHolder(@NonNull ViewGroup parentView, int layoutId) {
        super(parentView, layoutId);
    }

    public void bind(RateHistoryUIModel item) {

        if(getAdapterPosition() == 1) {
            textViewAverage.setTextSize(18f);
            textViewAverage.setTypeface(null, Typeface.BOLD);

        }

        textViewAverage.setText(item.getAverage());
        textViewTime.setText(item.getTime());

    }
}
