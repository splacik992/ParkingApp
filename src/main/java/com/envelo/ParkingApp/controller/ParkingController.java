package com.envelo.ParkingApp.controller;

import com.envelo.ParkingApp.services.EmailService;
import com.envelo.ParkingApp.services.ParkingService;
import com.google.zxing.WriterException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping(value = "/")
public class ParkingController {

    private final EmailService emailService;
    private final ParkingService parkingService;

    public ParkingController(EmailService emailService, ParkingService parkingService) {
        this.emailService = emailService;
        this.parkingService = parkingService;
    }

    @GetMapping
    public String getIndexView(Model model) {
        model.addAttribute("freeSpots" , parkingService.getFreeSpots(1));
        return "index";
    }

    @PostMapping
    public String makeReservation(@RequestParam(name = "spotId") String spotId)
            throws IOException, WriterException {

        parkingService.generateReservation(1, Integer.parseInt(spotId), 1);

        return "redirect:/";
    }
}