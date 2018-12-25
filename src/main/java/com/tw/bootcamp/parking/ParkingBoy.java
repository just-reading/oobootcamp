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
    return parkingLots.get(0).park(car);
  }
}
