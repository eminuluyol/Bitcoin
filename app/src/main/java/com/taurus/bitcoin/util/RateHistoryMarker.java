package com.taurus.bitcoin.util;

import android.content.Context;
import android.widget.TextView;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.taurus.bitcoin.R;

/**
 * Created by eminuluyol on 12/07/2017.
 */

public class RateHistoryMarker extends MarkerView {

  private TextView textViewMarker;

  public RateHistoryMarker(Context context) {
    super(context, R.layout.player_path_marker_view);
    textViewMarker = (TextView) findViewById(R.id.playerPathTextViewMarker);
  }

  @Override
  public void refreshContent(Entry e, Highlight highlight) {
    textViewMarker.setText(String.format("%.0f", e.getVal()));
  }

  @Override
  public int getXOffset(float xpos) {
    // this will center the marker-view horizontally
    return -(getWidth() / 2);
  }

  @Override
  public int getYOffset(float ypos) {
    // this will cause the marker-view to be above the selected value
    return -getHeight();
  }
}

