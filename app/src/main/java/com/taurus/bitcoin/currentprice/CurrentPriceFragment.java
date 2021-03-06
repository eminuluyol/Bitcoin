package com.taurus.bitcoin.currentprice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.taurus.bitcoin.R;
import com.taurus.bitcoin.baseadapter.RecyclerAdapter;
import com.taurus.bitcoin.baseadapter.model.GenericItem;
import com.taurus.bitcoin.core.BaseFragment;
import com.taurus.bitcoin.currentprice.adapter.delegate.CurrentPriceAdapterDelegate;
import com.taurus.bitcoin.currentprice.adapter.model.RateUIModel;
import com.taurus.bitcoin.listener.OnItemClickListener;
import com.taurus.bitcoin.network.model.currentprice.Rate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CurrentPriceFragment extends BaseFragment<CurrentPriceView, CurrentPricePresenter>
    implements CurrentPriceView, OnItemClickListener {

  @BindView(R.id.currentPriceRecyclerView)
  RecyclerView currentPriceRecyclerView;

  @BindView(R.id.emptyView)
  NestedScrollView emptyView;

  private RecyclerAdapter currentPriceListAdapter;

  public static CurrentPriceFragment newInstance() {
    return new CurrentPriceFragment();
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

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    currentPriceRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    currentPriceListAdapter = RecyclerAdapter.with(new CurrentPriceAdapterDelegate(this));
    currentPriceRecyclerView.setAdapter(currentPriceListAdapter);
    getPresenter().onProgressBarShow();
    getPresenter().onCurrentRatesRequested();

  }

  @Override
  public void showEmptyView() {
    emptyView.setVisibility(View.VISIBLE);
  }

  @Override
  public void hideEmptyView() {
    emptyView.setVisibility(View.GONE);
  }

  @Override
  public void showGetCurrenRateSuccess(List<GenericItem> data) {
    currentPriceListAdapter.swapItems(data);
  }

  @Override
  public void onItemClick(View view) {
    RateUIModel rateUIModel = (RateUIModel) view.getTag();
    getPresenter().onRateHistoryRequested(rateUIModel.getCurrencyCode());
  }

}
