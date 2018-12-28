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

  public ParkingTicket park(Car car) {
    if (cars.size() >= maxSpace) {
      throw new ParkingLotIsFullException();
    }
    ParkingTicket parkingTicket = new ParkingTicket();
    cars.put(parkingTicket, car);
    return parkingTicket;
  }

  public Car pick(ParkingTicket parkingTicket) {
    if (cars.containsKey(parkingTicket)) {
      return cars.remove(parkingTicket);
    }
    throw new InvalidTicketException();
  }

  public boolean contains(ParkingTicket ticket) {
    return cars.containsKey(ticket);
  }

  public boolean isFull() {
    return cars.size() >= maxSpace;
  }
}
