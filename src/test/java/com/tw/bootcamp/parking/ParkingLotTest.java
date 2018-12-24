package com.tw.bootcamp.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingLotTest {

  @Test
  void shouldReturnTicketWhenParkACarGivenParkingLotHasOneEmptySpace() {
    ParkingLot parkingLot = new ParkingLot(1);
    ParkingTicket ticket = parkingLot.in(new Car());

    assertNotNull(ticket);
  }

  @Test
  void shouldThrowParkingLotIsFullExceptionWhenParkACarGivenParkingLotHasNoEmptySpace() {
    ParkingLot parkingLot = new ParkingLot(1);
    parkingLot.in(new Car());

    assertThrows(ParkingLotIsFullException.class, () -> parkingLot.in(new Car()));
  }

}
