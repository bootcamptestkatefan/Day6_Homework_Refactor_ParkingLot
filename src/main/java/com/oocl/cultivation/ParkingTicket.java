package com.oocl.cultivation;

public class ParkingTicket {

    private String nameOfCar;

    private boolean used;

    public ParkingTicket (){
        this.used = false;
    }

    public ParkingTicket (String nameOfCar){
        this.nameOfCar = nameOfCar;
        this.used= false;
    }

    public boolean getUsed() {
        return this.used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }


}
