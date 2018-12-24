package com.tw.bootcamp.parking;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

  private Map<ParkingTicket, Car> cars;

  private int maxSpace;

  public ParkingLot(int maxSpace) {
    this.maxSpace = maxSpace;
    this.cars = new HashMap<>(maxSpace);
  }

  public ParkingTicket in(Car car) {
    if (cars.size() >= maxSpace) {
      throw new ParkingLotIsFullException();
    }
    ParkingTicket parkingTicket = new ParkingTicket();
    cars.put(parkingTicket, car);
    return parkingTicket;
  }

  public Car out(ParkingTicket parkingTicket) {
    return cars.get(parkingTicket);
  }
}
