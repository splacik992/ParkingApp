package com.envelo.ParkingApp.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date date;
    private String qrHashcode;
    @OneToOne
    private User user;
    private int parkingSpot;

    public Reservation(Date date, User user, int parkingSpot) {
        this.date = date;
        this.user = user;
        this.parkingSpot = parkingSpot;
        qrHashcode = generateHashCode();
    }

    private String generateHashCode() {

        return null;
    }

    public int getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(int parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getQrHashcode() {
        return qrHashcode;
    }

    public void setQrHashcode(String qrHashcode) {
        this.qrHashcode = qrHashcode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
