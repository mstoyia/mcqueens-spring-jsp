package com.cardealer.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Encapsulation the process by which data (Variables) and the code that acts upon then (methods) are integrated as a single unit (class). 
@Entity
@Table(name = "buyer") 
public class Buyer {
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

    // empty constructor
    // constructor allows you to set the initial state of an object
    public Buyer() {

    }

     //getters and setters
    // getters allow you to access a variable
    // setters allow you to modify a variable

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
