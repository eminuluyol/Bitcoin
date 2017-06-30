package com.taurus.bitcoin.currentprice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.taurus.bitcoin.R;
import com.taurus.bitcoin.core.BaseFragment;
import com.taurus.bitcoin.core.BaseSimpleActivity;
import com.taurus.bitcoin.network.model.Rate;

import java.util.ArrayList;
import java.util.List;

public class CurrentPriceActivity extends BaseSimpleActivity {

    private static final String EXTRA_RATE = "rate";
    private List<Rate> rateList;

    public static Intent newIntent(Context context, List<Rate> rateList) {

        Intent intent = new Intent(context, CurrentPriceActivity.class);
        intent.putParcelableArrayListExtra(CurrentPriceActivity.EXTRA_RATE, new ArrayList<>(rateList));

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
        return CurrentPriceFragment.newInstance(rateList);
    }

    private void getBundleArguments() {

        Intent extras = getIntent();

        if (extras != null) {
            rateList = extras.getParcelableArrayListExtra(CurrentPriceActivity.EXTRA_RATE);
        }

    }

}
