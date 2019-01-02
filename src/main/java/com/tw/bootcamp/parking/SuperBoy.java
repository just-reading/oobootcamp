package com.tw.bootcamp.parking;

import java.util.Collections;
import java.util.List;

public abstract class SuperBoy {

  protected List<ParkingLot> parkingLots;

  public SuperBoy(ParkingLot parkingLot) {
    this.parkingLots = Collections.singletonList(parkingLot);
  }

  public SuperBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  public abstract ParkingTicket park(Car car);

  public Car pick(ParkingTicket ticket) {
    for (ParkingLot parkingLot : parkingLots) {
      if (parkingLot.contains(ticket)) {
        return parkingLot.pick(ticket);
      }
    }
    throw new InvalidTicketException();
  }
}
