package com.cardealer.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "car")
public class Car {

    //primary key -unique variable for every car in the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "manufacturerName")
    private String manufacturerName;

    @Column(name = "dateOfPurchase")
    private LocalDate dateOfPurchase;

    @Column(name= "mileage")
    private int mileage;

    @Column(name = "price")
    private double price;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private int year;

    @Column(name = "vin")
    private String vin;

    @Column(name = "description", length=1000)
    private String description;

    @Column(name = "photoUrl")
    private String photoUrl;

    public String getStripePriceId() {
        return stripePriceId;
    }


    public void setStripePriceId(String stripePriceId) {
        this.stripePriceId = stripePriceId;
    }


    public List<Cart> getCart() {
        return cart;
    }


    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    @Column(name = "stripeprice_id")
    private String stripePriceId;

    //we use "mappedBy when we are on the non-owning /inverse side of a relationship between 2 models"
    @ManyToMany(mappedBy = "itemsinCart")
    private List<Cart> cart;

    //empty constructor
    // constructor allows you to set the initial state of an object
    public Car() {

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

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    
}
