package com.tw.bootcamp.parking;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SmartParkingBoyTest {

  @Test
  void shouldReturnTicketWhenParkACarGivenSmartParkingBoyHasTwoParkingLotAndTheyHaveTheSameParkingSpace() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(1);

    ParkingBoy parkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

    Car myCar = new Car();

    ParkingTicket parkingTicket = parkingBoy.park(myCar);

    assertNotNull(parkingTicket);
    assertSame(myCar, firstParkingLot.pick(parkingTicket));
  }
}
