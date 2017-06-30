package com.taurus.bitcoin.currentprice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.taurus.bitcoin.R;
import com.taurus.bitcoin.core.BaseFragment;
import com.taurus.bitcoin.network.model.Rate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CurrentPriceFragment extends BaseFragment<CurrentPriceView, CurrentPricePresenter>
        implements CurrentPriceView {

    private static final String EXTRA_RATE = "rate";
    private List<Rate> rateList;

    @BindView(R.id.currentPriceRecyclerView)
    RecyclerView currentPriceRecyclerView;

    @BindView(R.id.emptyView)
    NestedScrollView emptyView;

    public static CurrentPriceFragment newInstance(List<Rate> rateList) {

        Bundle args = new Bundle();
        args.putParcelableArrayList(CurrentPriceFragment.EXTRA_RATE, (ArrayList<Rate>) rateList);

        CurrentPriceFragment fragment = new CurrentPriceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_current_price;
    }

    @NonNull
    @Override
    public CurrentPricePresenter createPresenter() {
        return new CurrentPricePresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getBundleFromArgs();

        if (rateList != null && !rateList.isEmpty()) {



        }
    }

    private void getBundleFromArgs() {

        Bundle args = getArguments();
        if (args == null) return;
        rateList = args.getParcelableArrayList(CurrentPriceFragment.EXTRA_RATE);

    }

    @Override
    public void showEmptyView() {
        emptyView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmptyView() {
        emptyView.setVisibility(View.GONE);
    }
}