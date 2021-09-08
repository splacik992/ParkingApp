package com.envelo.ParkingApp.controller;

import com.envelo.ParkingApp.services.EmailService;
import com.envelo.ParkingApp.services.ParkingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.TableGenerator;

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
    public String getIndexView(){
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(){
        return "login";
    }


    @RequestMapping(value = "api/ticket/{email}", method = RequestMethod.POST)
    public String sendEmailWithTicket(@RequestParam String email) {
        return "redirect:/";
    }


    @RequestMapping(value = "api/admin/parking/", method = RequestMethod.GET)
    public String getAdminBoard() {
        return "adminBoard";
    }

    @RequestMapping(value = "api/admin/parking/{numOfSpots}", method = RequestMethod.POST)
    public String sendEmailWithTicket(@PathVariable Integer numOfSpots) {
        parkingService.createNewParking(numOfSpots);
        return "redirect:/";
    }

}
