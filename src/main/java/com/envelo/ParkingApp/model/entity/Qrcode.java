package com.envelo.ParkingApp.model.entity;

public class Qrcode {
    private String data;
    private String path;
    private String charset;

    public Qrcode(String data, String path, String charset) {
        this.data = data;
        this.path = path;
        this.charset = charset;
    }

}