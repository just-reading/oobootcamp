package com.tw.bootcamp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {

  @Test
  public void shouldReturnArea10WhenGetAreaGivenWidthIs2() {
    Rectangle rectangle = new Rectangle(2, 5);
    assertEquals(10, rectangle.getArea());
  }

  @Test
  public void shouldReturnWidth4WhenIncreaseWidthGiveLengthIs4AndWidthIs1() {
    Rectangle rectangle = new Rectangle(4, 1);
    while (rectangle.getLength() > rectangle.getWidth()) {
      rectangle.setWidth(rectangle.getWidth() + 1);
    }
    assertEquals(rectangle.getWidth(), rectangle.getLength());
  }
}
