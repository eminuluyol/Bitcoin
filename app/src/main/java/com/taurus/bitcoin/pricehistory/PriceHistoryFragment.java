package com.taurus.bitcoin.pricehistory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.taurus.bitcoin.R;
import com.taurus.bitcoin.baseadapter.RecyclerAdapter;
import com.taurus.bitcoin.baseadapter.model.GenericItem;
import com.taurus.bitcoin.core.BaseSimpleFragment;
import com.taurus.bitcoin.pricehistory.adapter.RateHistoryAdapterDelegate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class PriceHistoryFragment extends BaseSimpleFragment {

    private static final String EXTRA_RATE_HISTORY = "rate_history";

    @BindView(R.id.priceHistoryRecyclerView)
    RecyclerView priceHistoryRecyclerView;

    @BindView(R.id.emptyView)
    NestedScrollView emptyView;

    private List<GenericItem> rateHistoryList;


    public static PriceHistoryFragment newInstance(List<GenericItem> rateHistoryList) {

        Bundle args = new Bundle();
        args.putParcelableArrayList(PriceHistoryFragment.EXTRA_RATE_HISTORY, (ArrayList<GenericItem>) rateHistoryList);

        PriceHistoryFragment fragment = new PriceHistoryFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getBundleFromArgs();

        if(rateHistoryList.size() > 0 && rateHistoryList != null) {

            priceHistoryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            RecyclerAdapter rateHistoryAdapter = RecyclerAdapter.with(new RateHistoryAdapterDelegate());
            priceHistoryRecyclerView.setAdapter(rateHistoryAdapter);
            rateHistoryAdapter.swapItems(rateHistoryList);

        } else {

            emptyView.setVisibility(View.VISIBLE);

        }

    }


    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_price_history;
    }

    private void getBundleFromArgs() {

        Bundle args = getArguments();

        if (args == null) return;
        rateHistoryList = args.getParcelableArrayList(PriceHistoryFragment.EXTRA_RATE_HISTORY);

    }
}
