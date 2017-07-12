package com.taurus.bitcoin.util;

import java.util.Random;

/**
 * Created by eminuluyol on 10/07/2017.
 */

public class RandomColorGenetator {

  private static String[] colorArray = new String[]{"#EC6262","#9C27B0","#2196F3", "#66BB6A",
      "#CDDC39", "#FFC107"};

  public static String generateRandomColor() {


    Random ran = new Random();
    int x = ran.nextInt(colorArray.length);

    return colorArray[x];
  }
}
