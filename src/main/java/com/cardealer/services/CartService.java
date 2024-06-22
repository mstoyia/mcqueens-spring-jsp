package com.cardealer.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardealer.models.Car;
import com.cardealer.models.Cart;
import com.cardealer.repository.CarRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class CartService {
    @Autowired
    private CarRepository carRepository;

    //HTTPSession
    //Session is used to save user information temporarily on the server
    //We use the HTTPSession class to store temporary data / session-specific data


    //GET
    public Cart getCart(HttpSession session ) {
        // the getAttribute method allows you to load a value objects/entity/data that are previously set in the session
        Cart cart = (Cart)session.getAttribute("cart");
        //check whether any data was returned(gotten) from the session, so we have to create one and SET IT
        if(cart == null) {
            //WE INITIALIZE/ASSIGN A NEW CART OBJECT
            cart = new Cart();
            //we then set that new cart object in the session
            //setAttribute method allows to save data in the session
            session.setAttribute("cart", cart);
        }

        return cart;

    }

    //add To Cart
    //it's job is to get a cart
    //it'''s going to receive the id of the cart which it wants to add to the cart
    //it's going to use that id get the cart from the database
    //when it gets the car from the database, it's going to add it to the items in the cart
    public void addToCart(Long id, HttpSession session) {
        //get a cart
        Cart cart = getCart(session);
        //look for the car in the database with the id received
        Car carToAdd = carRepository.findById(id).orElse(null);
        //check whether car was returned with the given id, and if a car was returned. it will add the car to the cart
        if (carToAdd != null) {
            //adds car from database(carToAdd) to the itemsInCart list
            cart.getItemsinCart().add(carToAdd);
        }
    }

    //remove from cart
    public void removeFromCart(Long id, HttpSession session) {
        //get a cart(the current cart in the session)
        Cart cart = getCart(session);

        List<Car> itemsToRemove = new ArrayList<>();
        //the for each loop iterates through all the items in the cart
        for(Car car: cart.getItemsinCart()) {
             //if an id of a car in the cart matches with the id which was passed into this method. it will remove that car from the items in the cart
                //the id passed into this method represents the id of the car which you want to remove from the item in the cart.
            if (car.getId().equals(id)) {
                itemsToRemove.add(car);
            }
        }
        //this will remove the cart in the items ToRemove list from the items in the cart
        cart.getItemsinCart().removeAll(itemsToRemove);

    }

}
