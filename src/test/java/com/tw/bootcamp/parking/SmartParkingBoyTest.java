package com.tw.bootcamp.parking;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SmartParkingBoyTest {

  @Test
  void shouldReturnTicketWhenParkACarGivenSmartParkingBoyHasTwoParkingLotAndTheFirstEmptySpaceMoreThanTheSecond() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(2);

    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(
        Arrays.asList(firstParkingLot, secondParkingLot));

    Car myCar = new Car();
    ParkingTicket ticket = smartParkingBoy.park(myCar);

    assertNotNull(ticket);
    assertSame(myCar, secondParkingLot.pick(ticket));
  }

}
