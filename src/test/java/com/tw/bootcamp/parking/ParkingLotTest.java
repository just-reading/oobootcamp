package com.tw.bootcamp.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    ParkingLot parkingLot = new ParkingLot(0);

    assertThrows(ParkingLotIsFullException.class, () -> parkingLot.in(new Car()));
  }


  @Test
  void shouldReturnParkedCarWhenPickCarGivenParkingLotOnlyHasMyCar() {
    ParkingLot parkingLot = new ParkingLot(1);
    Car myCar = new Car();
    ParkingTicket ticket = parkingLot.in(myCar);

    Car pickedCar = parkingLot.out(ticket);

    assertEquals(myCar, pickedCar);
  }

  @Test
  void shouldReturnMyParkedCarWhenPickCarGivenParkingLotHaveMyCarAnAlsoHaveOthersCar() {
    ParkingLot parkingLot = new ParkingLot(2);
    parkingLot.in(new Car());
    Car myCar = new Car();
    ParkingTicket ticket = parkingLot.in(myCar);

    Car pickedCar = parkingLot.out(ticket);

    assertEquals(myCar, pickedCar);
  }

  @Test
  void shouldThrowInvalidTicketExceptionWhenPickCarTwiceGivenOneParkingTicket(){
    ParkingLot parkingLot = new ParkingLot(1);
    ParkingTicket ticket = parkingLot.in(new Car());
    parkingLot.out(ticket);

    assertThrows(InvalidTicketException.class,() -> parkingLot.out(ticket));
  }

}
