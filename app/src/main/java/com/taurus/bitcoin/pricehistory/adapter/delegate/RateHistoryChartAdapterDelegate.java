package com.taurus.bitcoin.pricehistory.adapter.delegate;

import android.support.annotation.NonNull;
import android.view.ViewGroup;
import butterknife.BindView;
import com.github.mikephil.charting.charts.LineChart;
import com.taurus.bitcoin.R;
import com.taurus.bitcoin.baseadapter.BaseAdapterDelegate;
import com.taurus.bitcoin.baseadapter.model.GenericItem;
import com.taurus.bitcoin.pricehistory.adapter.model.RateHistoryChartUIModel;
import com.taurus.bitcoin.pricehistory.adapter.viewholder.RateHistoryChartViewHolder;
import java.util.List;

/**
 * Created by eminuluyol on 12/07/2017.
 */

public class RateHistoryChartAdapterDelegate
    extends BaseAdapterDelegate<RateHistoryChartUIModel, GenericItem, RateHistoryChartViewHolder> {

  @Override
  protected boolean isForViewType(@NonNull GenericItem item, @NonNull List<GenericItem> items,
      int position) {
    return item instanceof RateHistoryChartUIModel;
  }

  @NonNull @Override
  protected RateHistoryChartViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
    return new RateHistoryChartViewHolder(parent, R.layout.chart_rate_history);
  }

  @Override protected void onBindViewHolder(@NonNull RateHistoryChartUIModel item,
      @NonNull RateHistoryChartViewHolder viewHolder, @NonNull List<Object> payloads) {
    viewHolder.bind(item);
  }
}
