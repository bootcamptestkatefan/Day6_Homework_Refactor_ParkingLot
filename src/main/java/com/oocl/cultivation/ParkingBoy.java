package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    private ParkingLot parkingLot;
    private String lastErrorMessage;
    private List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot parkingLot) { //constructor
        this.parkingLot = parkingLot;
        parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }

    public ParkingLot findAvailableParkingLot() {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAvailableParkingPosition() > 0) {
                return parkingLot;
            }
        }
        return null;
    }

    public ParkingTicket park(Car car) {
        ParkingLot theSelectedParkingLot = findAvailableParkingLot();
        if(theSelectedParkingLot != null){
            this.parkingLot = theSelectedParkingLot;
        }
        if (this.parkingLot.getAvailableParkingPosition() > 0) {
            ParkingTicket ticket = this.parkingLot.assign(car);
            this.lastErrorMessage = null;
            return ticket;
        }
        else {
            this.lastErrorMessage = "親，停車場已滿，你過主啦。";
            return null;
        }
    }

    public Car fetch(ParkingTicket ticket) {
        //input ticket, return car
        Car car = this.parkingLot.fetch(ticket);
        if (ticket == null) {
            this.lastErrorMessage = "親，你的票在哪?";
        } else if (ticket.getUsed()){
            this.lastErrorMessage = "親，你的票用過了。";
        } else {
            if (car == null) {
                this.lastErrorMessage = "親，你拿錯票了。";
            } else {
                this.lastErrorMessage = null;
                ticket.setUsed(true);
            }
        }
        return car;
        // TODO: Please implement the method
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
