package com.envelo.ParkingApp.controller;

import com.envelo.ParkingApp.services.EmailService;
import com.envelo.ParkingApp.services.ParkingService;
import com.google.zxing.WriterException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
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
    public String getIndexView() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(value = "api/ticket", method = RequestMethod.GET)
    public String sendEmailWithTicket() throws MessagingException, IOException, WriterException {
        emailService.sendEmailWithAttachment();
        return "redirect:/";
    }

    @RequestMapping(value = "api/admin/parking/", method = RequestMethod.GET)
    public String getAdminBoard() {
        return "adminBoard";
    }

    @RequestMapping(value = "api/admin/parking/{numOfSpots}", method = RequestMethod.POST)
    public String setAmountOfSpotsInParking(@PathVariable Integer numOfSpots) {
        parkingService.createNewParking(numOfSpots);
        return "redirect:/";
    }

    @RequestMapping(value = "api/reservation", method = RequestMethod.GET)
    public String showTicketView() {
        return "redirect:/";
    }

    @RequestMapping(value = "api/reservation/{userId}/{spotId}/{parkingId}", method = RequestMethod.GET)
    public String makeReservation(@PathVariable Long userId, @PathVariable Integer spotId, @PathVariable Long parkingId)
            throws IOException, WriterException {
        parkingService.generateReservation(userId, spotId, parkingId);

        return "redirect:/";
    }


}