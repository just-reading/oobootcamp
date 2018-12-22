package com.tw.bootcamp;

public class Length {

  private int length;

  private Unit unit;

  public Length(int length, Unit unit) {
    this.length = length;
    this.unit = unit;
  }

  public int compare(Length n) {

    int mTotal = length;
    if (unit == Unit.KM) {
      mTotal = length * 1000 * 1000;
    }
    if (unit == Unit.M) {
      mTotal = length * 1000;
    }

    int nTotal = n.length;

    if (n.unit == Unit.KM) {
      nTotal = n.length * 1000 * 1000;
    }
    if (n.unit == Unit.M) {
      nTotal = n.length * 1000;
    }

    return Integer.compare(mTotal, nTotal);
  }
}
