package com.envelo.ParkingApp.model.entity;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Parking {

    private int numOfSpots;
    private List<Reservation> reservations;

    public int getNumOfSpots() {
        return numOfSpots;
    }

    public void setNumOfSpots(int numOfSpots) {
        this.numOfSpots = numOfSpots;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
