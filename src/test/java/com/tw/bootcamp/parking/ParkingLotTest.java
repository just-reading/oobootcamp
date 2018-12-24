package com.tw.bootcamp.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingLotTest {

  @Test
  void shouldReturnTicketWhenParkACarGivenParkingLotHasOneEmptySpace() {
    ParkingLot parkingLot = new ParkingLot(1);
    ParkingTicket ticket = parkingLot.park(new Car());

    assertNotNull(ticket);
  }

  @Test
  void shouldThrowParkingLotIsFullExceptionWhenParkACarGivenParkingLotHasNoEmptySpace() {
    ParkingLot parkingLot = new ParkingLot(1);
    parkingLot.park(new Car());

    assertThrows(ParkingLotIsFullException.class, () -> parkingLot.park(new Car()));
  }


  @Test
  void shouldReturnParkedCarWhenPickCarGivenParkingLotOnlyHasMyCar() {
    ParkingLot parkingLot = new ParkingLot(1);
    Car myCar = new Car();
    ParkingTicket ticket = parkingLot.park(myCar);

    Car pickedCar = parkingLot.pickCar(ticket);

    assertSame(myCar, pickedCar);
  }

  @Test
  void shouldReturnMyParkedCarWhenPickCarGivenParkingLotHaveMyCarAnAlsoHaveOthersCar() {
    ParkingLot parkingLot = new ParkingLot(2);
    parkingLot.park(new Car());
    Car myCar = new Car();
    ParkingTicket ticket = parkingLot.park(myCar);

    Car pickedCar = parkingLot.pickCar(ticket);

    assertSame(myCar, pickedCar);
  }

  @Test
  void shouldThrowInvalidTicketExceptionWhenPickCarTwiceGivenOneParkingTicket() {
    ParkingLot parkingLot = new ParkingLot(1);
    ParkingTicket ticket = parkingLot.park(new Car());
    parkingLot.pickCar(ticket);

    assertThrows(InvalidTicketException.class, () -> parkingLot.pickCar(ticket));
  }

}
