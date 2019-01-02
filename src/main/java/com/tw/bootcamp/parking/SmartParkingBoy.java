package com.tw.bootcamp.parking;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends SuperBoy {

  public SmartParkingBoy(List<ParkingLot> parkingLots) {
    super(parkingLots);
  }

  @Override
  public ParkingTicket park(Car car) {
    ParkingLot parkingLotHasMaxAvailableSpaces = parkingLots.stream()
        .filter(parkingLot -> !parkingLot.isFull())
        .max(Comparator.comparing(ParkingLot::getAvailableSpaces))
        .orElse(null);
    if (parkingLotHasMaxAvailableSpaces != null) {
      return parkingLotHasMaxAvailableSpaces.park(car);
    }
    return null;
  }
}
