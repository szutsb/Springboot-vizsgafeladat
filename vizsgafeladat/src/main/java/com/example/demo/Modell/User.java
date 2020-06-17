package com.example.demo.Modell;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_seq")
    private Long userID;

    @Column(name = "firstName", nullable = false)
    @Size(min = 10, max = 50)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    @Size(min = 10, max = 50)
    private String lastName;

    @Column(name = "email", nullable = false)
    @Email
    private String email;

    @Column(name = "city", nullable = false)
    @Size(min = 10, max = 50)
    private String city;

    @Column(name = "streetAddress", nullable = false)
    @Size(min = 10, max = 100)
    private String streetAddress;

    @Column(name = "zipCode", nullable = false)
    private int zipCode;

    @Column(name = "phoneNumber", nullable = false)
    @Size(min = 1, max = 20)
    private String phoneNumber;

    @Column(name = "numberOfPurchases", nullable = false)
    private int numberOfPurchases;

    @Column(name = "regularCustomer", nullable = false)
    private boolean regularCustomer;

}
