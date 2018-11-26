package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<ParkingTicket, Car> cars = new HashMap<>();

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableParkingPosition() {
        return capacity - cars.size();
    }

    public int getCapacity(){
        return this.capacity;
    }

    public ParkingTicket assign(Car car){
        ParkingTicket ticket = new ParkingTicket(car.getName());
        cars.put(ticket, car);
        return ticket;
    }

    public Car fetch(ParkingTicket ticket){
        Car car = cars.remove(ticket);

        return car;
    }
}
