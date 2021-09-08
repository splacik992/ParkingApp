package com.envelo.ParkingApp.model.entity;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Qrcode {
    private String data;
    private String path;
    private String charset;
    private int height;
    private int width;

    public Qrcode(String data, String path, String charset, int height, int width) {
        this.data = data;
        this.path = path;
        this.charset = charset;
        this.height = height;
        this.width = width;
    }

    public void createQR() throws IOException, WriterException {
        createQR(this.path);
    }

    public void createQR(String path)
            throws WriterException, IOException {

        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(data.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, width, height);

        MatrixToImageWriter.writeToFile(
                matrix,
                path.substring(path.lastIndexOf('.') + 1),
                new File(path));
    }

    public String readQR()
            throws IOException, NotFoundException {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(
                        ImageIO.read(
                                new FileInputStream(path)))));

        Result result = new MultiFormatReader().decode(binaryBitmap);

        return result.getText();
    }
}