package com.taurus.bitcoin.pricehistory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import com.taurus.bitcoin.R;
import com.taurus.bitcoin.baseadapter.RecyclerAdapter;
import com.taurus.bitcoin.baseadapter.model.GenericItem;
import com.taurus.bitcoin.core.BaseFragment;
import com.taurus.bitcoin.core.BaseSimpleFragment;
import com.taurus.bitcoin.pricehistory.adapter.RateHistoryAdapterDelegate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class PriceHistoryFragment extends BaseFragment<PriceHistoryView, PriceHistoryPresenter>
    implements PriceHistoryView {

  private static final String EXTRA_CURRENCY_CODE = "currency_code";
  private String currencyCode;

  @BindView(R.id.priceHistoryRecyclerView)
  RecyclerView priceHistoryRecyclerView;

  @BindView(R.id.emptyView)
  NestedScrollView emptyView;

  private RecyclerAdapter rateHistoryAdapter;

  public static PriceHistoryFragment newInstance(String currencyCode) {

    Bundle args = new Bundle();
    args.putString(PriceHistoryFragment.EXTRA_CURRENCY_CODE, currencyCode);

    PriceHistoryFragment fragment = new PriceHistoryFragment();
    fragment.setArguments(args);

    return fragment;

  }

  @Override
  public PriceHistoryPresenter createPresenter() {
    return new PriceHistoryPresenter();
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    getBundleFromArgs();

    priceHistoryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    rateHistoryAdapter = RecyclerAdapter.with(new RateHistoryAdapterDelegate());
    priceHistoryRecyclerView.setAdapter(rateHistoryAdapter);
    getPresenter().onRateHistoryRequested(currencyCode);

  }

  @Override
  protected int getLayoutResId() {
    return R.layout.fragment_price_history;
  }

  private void getBundleFromArgs() {

    Bundle args = this.getArguments();

    if (args == null) return;
    currencyCode = args.getString(PriceHistoryFragment.EXTRA_CURRENCY_CODE);

  }

  @Override
  public void showGetHistorySuccess(List<GenericItem> detailList) {
    rateHistoryAdapter.swapItems(detailList);
  }

}
