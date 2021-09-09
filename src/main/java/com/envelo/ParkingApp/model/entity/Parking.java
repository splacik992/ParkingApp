package com.envelo.ParkingApp.model.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numOfSpots;
    @OneToMany
    private List<Reservation> reservations;

    public Parking() {
    }

    public Parking(int numOfSpots) {
        this.numOfSpots = numOfSpots;
        reservations = new LinkedList<>();
    }

    public int getNumOfSpots() {
        return numOfSpots;
    }

    public void setNumOfSpots(int numOfSpots) {
        this.numOfSpots = numOfSpots;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }
}