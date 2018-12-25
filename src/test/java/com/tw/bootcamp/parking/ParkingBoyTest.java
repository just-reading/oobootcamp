package com.tw.bootcamp.parking;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ParkingBoyTest {

  @Test
  void shouldReturnTicketWhenParkACarGivenParkingBoyHasOneEmptySpace() {
    ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));

    ParkingTicket ticket = parkingBoy.park(new Car());

    assertNotNull(ticket);
  }

  @Test
  void shouldReturnTicketWhenParkACarGivenParkingBoyHasTwoEmptyParkingLot() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(1);
    List<ParkingLot> parkingLots = Arrays.asList(firstParkingLot, secondParkingLot);
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

    Car myCar = new Car();
    ParkingTicket ticket = parkingBoy.park(myCar);

    assertNotNull(ticket);
    assertSame(myCar, firstParkingLot.pickCar(ticket));
  }

  @Test
  void shouldReturnTicketWhenParkACarGivenParkingBoyHasTwoParkingLotAndOneIsFullOtherIsEmpty(){
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(1);
    firstParkingLot.park(new Car());
    List<ParkingLot> parkingLots = Arrays.asList(firstParkingLot, secondParkingLot);
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

    Car myCar = new Car();
    ParkingTicket ticket = parkingBoy.park(myCar);

    assertNotNull(ticket);
    assertSame(myCar, secondParkingLot.pickCar(ticket));
  }
}
