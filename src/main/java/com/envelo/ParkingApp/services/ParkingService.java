package com.envelo.ParkingApp.services;

import com.envelo.ParkingApp.model.entity.Parking;
import com.envelo.ParkingApp.model.entity.Qrcode;
import com.envelo.ParkingApp.model.entity.Reservation;
import com.envelo.ParkingApp.model.entity.User;
import com.envelo.ParkingApp.repository.ParkingRepository;
import com.envelo.ParkingApp.repository.ReservationRepository;
import com.envelo.ParkingApp.repository.UserRepository;
import com.google.zxing.WriterException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class ParkingService {
    private final UserRepository userRepository;
    private final ParkingRepository parkingRepository;
    private final ReservationRepository reservationRepository;
    private final EmailService emailService;


    public ParkingService(UserRepository userRepository, ParkingRepository parkingRepository, ParkingRepository parkingRepository1, ReservationRepository reservationRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.parkingRepository = parkingRepository1;
        this.reservationRepository = reservationRepository;
        this.emailService = emailService;
    }

    public void createNewParking(int numberOfSpots) {
        Parking parking = new Parking(numberOfSpots);
        parkingRepository.save(parking);
    }

    public void updateParking(long parkingID, int numberOfSpots) {
        Parking parking = parkingRepository.findParkingById(parkingID);
        parking.setNumOfSpots(numberOfSpots);
        parkingRepository.save(parking);
    }

    public List<Integer> getFreeSpots(long parkingId) {
        List<Integer> freeSpots = new ArrayList<>();
        Parking parkingById = parkingRepository.findParkingById(parkingId);
        boolean[] spots = new boolean[parkingById.getNumOfSpots()];
        List<Reservation> reservations = parkingById.getReservations();
        for (Reservation r : reservations) {
            spots[r.getParkingSpot()] = true;
        }
        for (int i = 0; i < spots.length; i++) {
            if (!spots[i])
                freeSpots.add(i);
        }
        return freeSpots;
    }

    public void generateReservation(long userId, int spotId, long parkingId) throws IOException, WriterException {
        User user = userRepository.findUserById(userId);
        String date = new GregorianCalendar().getTime().toString();
        Parking parking = parkingRepository.findParkingById(parkingId);
        Reservation reservation = new Reservation(date, user, spotId);
        parking.addReservation(reservation);
        reservationRepository.save(reservation);
        Qrcode.createQR(reservation.getQrHashcode(), "qrcode.png", 200, 200);
        emailService.prepareAndSend(user.getEmail(), "<h1>W załączniku masz potrzebny Qrcode!</h1>", "Twój bilet");
    }
}