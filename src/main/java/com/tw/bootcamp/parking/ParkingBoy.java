package com.tw.bootcamp.parking;

import java.util.List;

public class ParkingBoy extends SuperBoy {

  public ParkingBoy(ParkingLot parkingLot) {
    super(parkingLot);
  }

  public ParkingBoy(List<ParkingLot> parkingLots) {
    super(parkingLots);
  }

  public ParkingTicket park(Car car) {
    for (ParkingLot parkingLot : parkingLots) {
      if (!parkingLot.isFull()) {
        return parkingLot.park(car);
      }
    }
    throw new ParkingLotIsFullException();
  }
}
