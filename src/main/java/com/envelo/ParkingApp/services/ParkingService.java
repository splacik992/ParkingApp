package com.envelo.ParkingApp.services;

import com.envelo.ParkingApp.model.entity.Parking;
import com.envelo.ParkingApp.model.entity.Reservation;
import com.envelo.ParkingApp.model.entity.User;
import com.envelo.ParkingApp.repository.ParkingRepository;
import com.envelo.ParkingApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class ParkingService {
    private final UserRepository userRepository;
    private final ParkingRepository parkingRepository;

    public ParkingService(UserRepository userRepository, ParkingRepository parkingRepository, ParkingRepository parkingRepository1) {
        this.userRepository = userRepository;
        this.parkingRepository = parkingRepository1;
    }

    public void createNewParking(int numberOfSpots){
        Parking parking = new Parking(numberOfSpots);
        parkingRepository.save(parking);
    }


    public void generateReservation(long userId, int spotId, long parkingId) {
        Parking parking = parkingRepository.findParkingById(parkingId);
        User user = userRepository.findUserById(userId);

        Date date = new GregorianCalendar().getTime();

        Reservation reservation = new Reservation(date, user, spotId);

        parking.addReservation(reservation);

    }

    public void setReservationDate() {

    }
}
