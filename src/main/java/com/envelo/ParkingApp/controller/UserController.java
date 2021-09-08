package com.envelo.ParkingApp.controller;

import com.envelo.ParkingApp.model.entity.User;
import com.envelo.ParkingApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("logIn")
    public ResponseEntity<User> logIn(@RequestParam("email") String email, @RequestParam("password") String password) {
        User user = userRepository.findUserByEmailAndPassword(email, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
