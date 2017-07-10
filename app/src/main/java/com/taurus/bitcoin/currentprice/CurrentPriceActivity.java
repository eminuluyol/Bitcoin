package com.taurus.bitcoin.currentprice;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.taurus.bitcoin.R;
import com.taurus.bitcoin.core.BaseFragment;
import com.taurus.bitcoin.core.BaseSimpleActivity;


public class CurrentPriceActivity extends BaseSimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.current_price_title);

    }

    @Nullable
    @Override
    protected BaseFragment getContainedFragment() {
        return CurrentPriceFragment.newInstance();
    }

}
