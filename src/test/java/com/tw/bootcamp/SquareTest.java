package com.tw.bootcamp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareTest {

  @Test
  public void shouldReturnArea4WhenGetAreaGivenWidthIs2() {
    Square square = new Square(2);
    assertEquals(4, square.getArea());
  }
}
