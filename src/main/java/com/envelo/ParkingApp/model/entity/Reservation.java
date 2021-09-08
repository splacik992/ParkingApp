package com.envelo.ParkingApp.model.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date date;
    private String hashCode;
    @OneToOne
    private User user;
    private int parkingSpot;

    public Reservation(Date date, User user, int parkingSpot) {
        this.date = date;
        this.user = user;
        this.parkingSpot = parkingSpot;
        hashCode = generateHashCode();
    }

    private String generateHashCode() {
        String sb = "Date:" + date +
                "Email:" + user.getEmail() +
                "SpotId:" + parkingSpot;
        String hash = getMd5(sb);
        return String.valueOf(hash);
    }

    private static String getMd5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
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
        return hashCode;
    }

    public void setQrHashcode(String hashCode) {
        this.hashCode = hashCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
