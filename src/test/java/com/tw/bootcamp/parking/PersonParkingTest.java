package com.tw.bootcamp.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PersonParkingTest {

  @Test
  void shouldReturnOneParkingTicketWhenParkOneCarGivenParkingLotHaveEnoughParkingSpace() {
    ParkingLot parkingLot = new ParkingLot(20);
    ParkingTicket parkingTicket = parkingLot.in("A90823");
    assertNotNull(parkingTicket);
  }

  @Test
  void shouldReturnMultiParkingTicketWhenParkMultiCarGivenParkingLotHaveEnoughParkingSpace() {
    ParkingLot parkingLot = new ParkingLot(20);
    ParkingTicket parkingTicket = parkingLot.in("A90823");
    assertNotNull(parkingTicket);
  }

}
