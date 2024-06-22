package com.cardealer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardealer.repository.BuyerRepository;
import com.cardealer.repository.SellerRepository;
import com.cardealer.models.Buyer;
import com.cardealer.models.Seller;

@Service
public class AuthenticationService {


    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private BuyerRepository buyerRepository;


    //Object: this is a generic data type which can represent any type of object
    //Object can point to any data type
    public Object signIn(String email, String password) throws Exception {

        //  check whether the buyer exists in the database, using their email
    Buyer foundBuyer = buyerRepository.findByEmail(email);
    
    //checking if the buyerrepository found anything in the database with the entered email
    if(foundBuyer != null){
    
    //check if the password for the foundbuyer from the database matches the password from the buyer entered in the view/jsp page
    if(!foundBuyer.getPassword().equals(password)){
        throw new Exception("Invalid credenitials. Wrong password");
    }

    return foundBuyer;
    } 
         Seller foundSeller = sellerRepository.findByEmail(email);

        if(foundSeller != null){

            if(!foundSeller.getPassword().equals(password)){
                throw new Exception("Invalid credenitials. Wrong password");
            }     

        }

        return foundSeller;

    }
}
    
