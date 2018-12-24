package com.tw.bootcamp.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

  private List<Car> cars;

  private int maxSpace;

  public ParkingLot(int maxSpace) {
    this.maxSpace = maxSpace;
    this.cars = new ArrayList<>(maxSpace);
  }

  public ParkingTicket in(Car car) {
    if(cars.size() >= maxSpace){
      throw new ParkingLotIsFullException();
    }
    cars.add(car);
    return new ParkingTicket();
  }
}
