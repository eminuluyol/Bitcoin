package com.taurus.bitcoin.pricehistory.adapter.model;

import com.taurus.bitcoin.baseadapter.model.GenericItem;
import java.util.List;

/**
 * Created by eminuluyol on 12/07/2017.
 */

public class RateHistoryChartUIModel extends GenericItem {

  private List<LineObject> lineObjects;

  public RateHistoryChartUIModel() {
  }

  public List<LineObject> getLineObjects() {
    return lineObjects;
  }

  public void setLineObjects(List<LineObject> lineObjects) {
    this.lineObjects = lineObjects;
  }
}
