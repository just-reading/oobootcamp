package com.tw.bootcamp.parking;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SmartParkingBoyTest {

  @Test
  void shouldReturnTicketWhenParkACarGivenSmartParkingBoyHasTwoParkingLotAndTheyHaveTheSameParkingSpace() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(1);

    SuperBoy parkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

    Car myCar = new Car();

    ParkingTicket parkingTicket = parkingBoy.park(myCar);

    assertNotNull(parkingTicket);
    assertSame(myCar, firstParkingLot.pick(parkingTicket));
  }

  @Test
  void shouldReturnTicketWhenParkACarGivenSmartParkingBoyHasTwoParkingLotAndTheSecondParkingLotHasMoreParkingSpace() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(2);

    SuperBoy parkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

    Car myCar = new Car();

    ParkingTicket parkingTicket = parkingBoy.park(myCar);

    assertNotNull(parkingTicket);
    assertSame(myCar, secondParkingLot.pick(parkingTicket));
  }

  @Test
  void shouldThrowParkingLotIsFullExceptionWhenParkACarGivenSmartParkingBoyHasTwoParkingLotAndAllParkingLotsHasNoParkingSpace() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(1);

    firstParkingLot.park(new Car());
    secondParkingLot.park(new Car());

    SuperBoy parkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

    assertThrows(ParkingLotIsFullException.class, () -> parkingBoy.park(new Car()));
  }

  @Test
  void shouldReturnParkedCarWhenPickACarGivenSmartParkingBoyHasOneParkingLotAndHasBeenParkedTheCar() {

    SuperBoy parkingBoy = new SmartParkingBoy(Collections.singletonList(new ParkingLot(1)));

    Car myCar = new Car();

    ParkingTicket parkingTicket = parkingBoy.park(myCar);

    assertSame(myCar, parkingBoy.pick(parkingTicket));
  }

  @Test
  void shouldReturnParkedCarWhenPickACarGivenSmartParkingBoyHasTwoParkingLotAndHasBeenParkedTheCarToSecondParkingLot() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(1);
    Car myCar = new Car();
    ParkingTicket parkingTicket = secondParkingLot.park(myCar);

    SuperBoy parkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

    assertSame(myCar, parkingBoy.pick(parkingTicket));
  }

  @Test
  void shouldThrowInvalidTicketExceptionWhenPickACarGivenSmartParkingBoyHasOneParkingLot() {
    SuperBoy parkingBoy = new SmartParkingBoy(Collections.singletonList(new ParkingLot(1)));

    assertThrows(InvalidTicketException.class, () -> parkingBoy.pick(new ParkingTicket()));
  }

}
