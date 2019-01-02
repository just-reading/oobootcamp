package com.tw.bootcamp.parking;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartParkingBoyTest {

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
  void shouldReturnTicketWhenParkACarGivenSmartParkingBoyHasTwoParkingLotAndAllParkingLotsHasNoParkingSpace() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(1);

    firstParkingLot.park(new Car());
    secondParkingLot.park(new Car());

    SuperBoy parkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

    assertThrows(ParkingLotIsFullException.class, () -> parkingBoy.park(new Car()));
  }
}
