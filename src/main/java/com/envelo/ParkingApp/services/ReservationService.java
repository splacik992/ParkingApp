package com.envelo.ParkingApp.services;

import com.envelo.ParkingApp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final UserRepository userRepository;

    public ReservationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void generateHash(){

    }



    //email - user
    //data - reservation
    //
}
