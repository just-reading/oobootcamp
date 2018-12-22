package com.tw.bootcamp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareLength {

  @Test
  void shouldReturn1WhenCompareGivenMIs5NIs4() {
    Length m = new Length(5, Unit.KM);
    Length n = new Length(4, Unit.KM);

    assertEquals(1, m.compare(n));
  }

  @Test
  void shouldReturnMinus1WhenCompareGivenMIs4NIs5() {
    Length m = new Length(4, Unit.KM);
    Length n = new Length(5, Unit.KM);

    assertEquals(-1, m.compare(n));
  }

  @Test
  void shouldReturn0WhenCompareGivenMIs5NIs5() {
    Length m = new Length(5, Unit.KM);
    Length n = new Length(5, Unit.KM);

    assertEquals(0, m.compare(n));
  }

  @Test
  void shouldReturn1WhenCompareMIs1kmNIs5mm() {
    Length m = new Length(1, Unit.KM);
    Length n = new Length(5, Unit.MM);

    assertEquals(1, m.compare(n));
  }

  @Test
  void shouldReturn1WhenCompareMIs1mNIs10000mm() {
    Length m = new Length(1, Unit.M);
    Length n = new Length(10000, Unit.MM);

    assertEquals(-1, m.compare(n));
  }

  @Test
  void shouldReturn0WhenCompareMIs3kmNIs3000m(){

  }

}
