package com.taurus.bitcoin.pricehistory.adapter.viewholder;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.ViewGroup;
import butterknife.BindView;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.taurus.bitcoin.R;
import com.taurus.bitcoin.baseadapter.viewholder.BaseViewHolder;
import com.taurus.bitcoin.pricehistory.adapter.model.LineObject;
import com.taurus.bitcoin.pricehistory.adapter.model.RateHistoryChartUIModel;
import com.taurus.bitcoin.util.RateHistoryMarker;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

/**
 * Created by eminuluyol on 12/07/2017.
 */

public class RateHistoryChartViewHolder extends BaseViewHolder {

  @BindView(R.id.rateHistoryChart)
  LineChart rateHistoryChart;

  private Context context;
  private LineDataSet dataRateHistory = null;
  private LineData data;

  public RateHistoryChartViewHolder(@NonNull ViewGroup parentView, int layoutId) {
    super(parentView, layoutId);
    context = parentView.getContext();

  }

  public void bind(RateHistoryChartUIModel item) {

    configureChart(rateHistoryChart);

    ArrayList<String> labels = new ArrayList<>();

    List<Entry> entriesRateHistory = new ArrayList<>();
    int colorRateHistory  = ContextCompat.getColor(context, R.color.cyan);

    configureXAxis(item, labels, entriesRateHistory);

    configureCallUsage(entriesRateHistory, labels,colorRateHistory);

  }

  private void configureChart(LineChart lineChart) {

    //Config chart
    lineChart.setDescription("");
    lineChart.setNoDataText(context.getResources().getString(R.string.no_data));
    lineChart.setNoDataTextDescription("");
    lineChart.getLegend().setEnabled(false);
    lineChart.setTouchEnabled(true);
    lineChart.setAutoScaleMinMaxEnabled(true);
    lineChart.setPinchZoom(false);

    //XAxis config
    XAxis xAxis = lineChart.getXAxis();
    xAxis.setDrawAxisLine(true);
    xAxis.setDrawGridLines(false);
    xAxis.setDrawLabels(true);
    xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
    xAxis.setYOffset(10);
    xAxis.setTextColor(ContextCompat.getColor(context, R.color.black64));
    xAxis.setTypeface(Typeface.DEFAULT_BOLD);
    xAxis.setTextSize(8);
    xAxis.setDrawLimitLinesBehindData(true);
    MarkerView marker = new RateHistoryMarker(context);
    lineChart.setMarkerView(marker);

    //YAxis config
    YAxis yAxis = lineChart.getAxisLeft();
    YAxis yr = lineChart.getAxisRight();
    yr.setEnabled(false);

    yAxis.setValueFormatter(new LargeValueFormatter());

    yAxis.setDrawGridLines(true);
    yAxis.setTextColor(ContextCompat.getColor(context, R.color.black64));
    yAxis.setDrawAxisLine(false);
    yAxis.setDrawLabels(true);

    yAxis.setDrawLimitLinesBehindData(false);
    yAxis.disableGridDashedLine();
    yAxis.setAxisMinValue(0f);
    yAxis.setDrawZeroLine(false);

    lineChart.setViewPortOffsets(90f, 16f, 30f, 40f);

  }

  private void configureXAxis(RateHistoryChartUIModel rateHistoryChartUIModel, ArrayList<String> labels, List<Entry> entriesRateHistory) {

    int i = 0;

    for(LineObject lineObject : rateHistoryChartUIModel.getLineObjects()) {

      entriesRateHistory.add(new BarEntry(lineObject.getRateHistoryValue(), i));

      i++;

      if(i == 1) {
        labels.add(" ");
      } else {
        labels.add(context.getString(R.string.min, String.valueOf(i - 1)));
      }

    }
  }

  private void configureCallUsage(List<Entry> entriesCallUsage, ArrayList<String> labels, int colorCallUsage) {

    if(!entriesCallUsage.isEmpty()) {

      dataRateHistory = new LineDataSet(entriesCallUsage, "Rate History");
      dataRateHistory.setDrawValues(false);
      dataRateHistory.setColor(colorCallUsage);
      dataRateHistory.setLineWidth(2f);
      dataRateHistory.setDrawCircles(true);
      dataRateHistory.setCircleColor(colorCallUsage);
      dataRateHistory.setDrawFilled(true);
      dataRateHistory.setDrawCubic(true);
      dataRateHistory.setFillColor(colorCallUsage);
      dataRateHistory.setDrawCircleHole(false);

    }

    if(dataRateHistory != null) {

      data = new LineData(labels, dataRateHistory);
      rateHistoryChart.setData(data);
      rateHistoryChart.animateY(500, Easing.EasingOption.EaseOutQuart);
      rateHistoryChart.notifyDataSetChanged();
      rateHistoryChart.invalidate();

    }

  }
}
