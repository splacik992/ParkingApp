package com.envelo.ParkingApp.model.entity;

import java.util.List;

public class Parking {
    private int numOfSpots;
    private List<Reservation> permanentSpot;
    private List<Reservation> reservations;

    public Parking(int numOfSpots, List<Reservation> permanentSpot, List<Reservation> reservations) {
        this.numOfSpots = numOfSpots;
        this.permanentSpot = permanentSpot;
        this.reservations = reservations;
    }

    public int getNumOfSpots() {
        return numOfSpots;
    }

    public void setNumOfSpots(int numOfSpots) {
        this.numOfSpots = numOfSpots;
    }

    public List<Reservation> getPermanentSpot() {
        return permanentSpot;
    }

    public void setPermanentSpot(List<Reservation> permanentSpot) {
        this.permanentSpot = permanentSpot;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
