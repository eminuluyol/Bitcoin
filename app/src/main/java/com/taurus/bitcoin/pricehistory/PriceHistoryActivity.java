package com.taurus.bitcoin.pricehistory;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.taurus.bitcoin.R;
import com.taurus.bitcoin.baseadapter.model.GenericItem;
import com.taurus.bitcoin.core.BaseFragment;
import com.taurus.bitcoin.core.BaseSimpleActivity;

import java.util.ArrayList;
import java.util.List;

public class PriceHistoryActivity extends BaseSimpleActivity {

    private static final String EXTRA_CURRENCY_CODE = "currency_code";

    private String currencyCode;

    public static Intent newIntent(Context context, String currencyCode) {

        Intent intent = new Intent(context, PriceHistoryActivity.class);
        intent.putExtra(EXTRA_CURRENCY_CODE, currencyCode);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getBundleArguments();
        super.onCreate(savedInstanceState);

        setTitle(getResources().getString(R.string.price_history_title, currencyCode));
        setHomeAsUpEnabled(true);

    }

    @Nullable
    @Override
    protected BaseFragment getContainedFragment() {
        return PriceHistoryFragment.newInstance(currencyCode);
    }

    private void getBundleArguments() {

        Intent extras = getIntent();

        if (extras != null) {
            currencyCode = extras.getStringExtra(PriceHistoryActivity.EXTRA_CURRENCY_CODE);
        }

    }
}
