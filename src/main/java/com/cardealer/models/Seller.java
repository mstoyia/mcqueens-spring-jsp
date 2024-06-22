package com.cardealer.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="seller")
//automatically generate boiler code e.g. getters/setters, empty constructors, toString method, etc.
@Data
public class Seller {
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "firstName")
    public String firstName;

   
    @Column(name = "lastName")
    public String lastName;

    @Column(name = "address")
    public String address;

    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String password;

    @Column(name = "phoneNNumber")
    public String phoneNumber;


}
