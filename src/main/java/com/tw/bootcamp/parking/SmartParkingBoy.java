package com.tw.bootcamp.parking;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

  SmartParkingBoy(List<ParkingLot> parkingLots) {
    super(parkingLots);
  }


  @Override
  public ParkingTicket park(Car car) {
    return parkingLots.get(1).park(car);
  }
}
