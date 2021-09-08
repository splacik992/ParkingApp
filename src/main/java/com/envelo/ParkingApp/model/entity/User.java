package com.envelo.ParkingApp.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
