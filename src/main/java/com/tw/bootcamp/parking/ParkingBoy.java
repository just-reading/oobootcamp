package com.tw.bootcamp.parking;

import java.util.Collections;
import java.util.List;

public class ParkingBoy {

  private List<ParkingLot> parkingLots;

  public ParkingBoy(ParkingLot parkingLot) {
    this.parkingLots = Collections.singletonList(parkingLot);
  }

  public ParkingBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  public ParkingTicket park(Car car) {
    for (ParkingLot parkingLot : parkingLots) {
      if (!parkingLot.isFull()) {
        return parkingLot.park(car);
      }
    }
    throw new ParkingLotIsFullException();
  }

  public Car pickCar(ParkingTicket ticket) {
    for (ParkingLot parkingLot : parkingLots) {
      if (parkingLot.hasCar(ticket)) {
        return parkingLot.pickCar(ticket);
      }
    }
    throw new InvalidTicketException();
  }
}
