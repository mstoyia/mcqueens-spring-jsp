package com.cardealer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardealer.models.Buyer;
import com.cardealer.repository.BuyerRepository;

import jakarta.servlet.http.HttpSession;

//methods in this layer which allow you to manipulate data before it reaches the database or if it is coming from the database and going to the view
//Business logic layer
@Service
public class BuyerService {

    //dependency injection
    @Autowired
    private BuyerRepository buyerRepository;

    //this method takes in a buyer object and asks the buyer repository to save it in the database
    //access modifier, return type, method name {parameters} {body}
    public Buyer signUp(Buyer buyer) {

        //other code depending on what you want to do with the data before it reaches the database e. g. encrypting the password
        

        //data type variable = ask middleman to save buyer
        Buyer savedBuyer = buyerRepository.save(buyer);

        return savedBuyer;

    }

    public Buyer signIn(Buyer buyer) throws Exception {
        Buyer foundBuyer = buyerRepository.findByEmail(buyer.getEmail());
        

        //checking if the buyer repository found anything in the database with the entered email
        if (foundBuyer == null) {
            throw new Exception("Buyer not found");
        }
        // check if the password for the foundBuyer from the database matches the password from the buyer entered in the view/jsp page
        if (!foundBuyer.getPassword().equals(buyer.getPassword())) {
            throw new Exception("Invalid credentials. Wrong password");

        }

        return foundBuyer;
    }

    public Buyer findById(Long id){
        Buyer buyer = buyerRepository.findById(id).orElse(null);
                return buyer;
                
    }

    public Buyer editProfile(Buyer buyer, HttpSession session) {

        //go to the database and find the buyer that I want to edit based on the id I give
        Buyer sessionBuyer = (Buyer) session.getAttribute("user");


        Buyer editedBuyer = buyerRepository.findById(sessionBuyer.getId()).orElse(null);

        editedBuyer.setFirstName(buyer.getFirstName());
        editedBuyer.setLastName(buyer.getLastName());
        editedBuyer.setAddress(buyer.getAddress());
        editedBuyer.setEmail(buyer.getEmail());
        editedBuyer.setPhoneNumber(buyer.getPhoneNumber());

        return buyerRepository.save(editedBuyer);
    }

    
    
}
