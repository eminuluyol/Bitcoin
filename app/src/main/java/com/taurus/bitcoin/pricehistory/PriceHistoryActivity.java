package com.taurus.bitcoin.pricehistory;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.taurus.bitcoin.R;
import com.taurus.bitcoin.core.BaseFragment;
import com.taurus.bitcoin.core.BaseSimpleActivity;
import com.taurus.bitcoin.currentprice.CurrentPriceActivity;
import com.taurus.bitcoin.currentprice.CurrentPriceFragment;
import com.taurus.bitcoin.currentprice.adapter.model.RateUIModel;
import com.taurus.bitcoin.network.model.currentprice.Rate;

import java.util.ArrayList;
import java.util.List;

public class PriceHistoryActivity extends BaseSimpleActivity {

    private static final String EXTRA_RATE = "rate";
    private List<RateUIModel> rateList;

    public static Intent newIntent(Context context, List<Rate> rateList) {

        Intent intent = new Intent(context, PriceHistoryActivity.class);
        intent.putParcelableArrayListExtra(PriceHistoryActivity.EXTRA_RATE, new ArrayList<>(rateList));

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getBundleArguments();
        super.onCreate(savedInstanceState);

        setTitle(R.string.current_price_title);

    }

    @Nullable
    @Override
    protected BaseFragment getContainedFragment() {
        return PriceHistoryFragment.newInstance(rateList);
    }

    private void getBundleArguments() {

        Intent extras = getIntent();

        if (extras != null) {
            rateList = extras.getParcelableArrayListExtra(PriceHistoryActivity.EXTRA_RATE);
        }

    }
}
