package com.taurus.bitcoin.currentprice.adapter.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.taurus.bitcoin.R;
import com.taurus.bitcoin.baseadapter.viewholder.BaseViewHolder;
import com.taurus.bitcoin.currentprice.adapter.model.RateUIModel;
import com.taurus.bitcoin.listener.OnItemClickListener;

import butterknife.BindView;
import butterknife.OnClick;

public class CurrentPriceViewHolder extends BaseViewHolder {

    @BindView(R.id.currentPriceTextViewCode)
    TextView textViewCode;

    @BindView(R.id.currentPriceTextViewName)
    TextView textViewName;

    @BindView(R.id.currentPriceTextViewRate)
    TextView textViewRate;

    private RateUIModel rateUIModel;

    private OnItemClickListener callback;

    public CurrentPriceViewHolder(@NonNull ViewGroup parentView, int layoutId, OnItemClickListener callback) {
        super(parentView, layoutId);

        this.callback = callback;
    }

    public  void bind (RateUIModel rateUIModel) {

        this.rateUIModel = rateUIModel;

        textViewCode.setText(rateUIModel.getCurrencyCode());
        textViewName.setText(rateUIModel.getName());
        textViewRate.setText(rateUIModel.getRate());

    }

    @OnClick(R.id.currentPriceLinearLayoutContainer)
    public void onViewClicked(View view) {

        view.setTag(rateUIModel);
        callback.onItemClick(view);

    }

}
