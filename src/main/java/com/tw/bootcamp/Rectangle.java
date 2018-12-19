package com.tw.bootcamp;

public class Rectangle {
  private double width;
  private double length;

  public Rectangle(double length, double width) {
    this.width = width;
    this.length = length;
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public double getArea() {
    return this.length * this.width;
  }

  public void increaseWidth() {
    while (length > width) {
      width++;
    }
  }
}
