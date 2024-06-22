package com.cardealer.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardealer.models.Buyer;
import com.cardealer.models.Car;
import com.cardealer.repository.CarRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;
    
    //access modifier, return data type, method name {parameters} {body of code}
    public List<Car> findAvailableCars() {

        //availableCars is a container that will hold whatever is returned from the database
        //the findAll() method will do a "select * from  car" in the database which loads all car records in the car table
        //what is returned from the findAll() method is stored in "availableCars"
        List<Car> availableCars = carRepository.findAll();
        List<Car> carsAfterDisc = discountCars(availableCars);

        return carsAfterDisc;

    }
    //When a data type is wrapped around Optional it means that it could possibly return empty/null
    public Car getCar(Long id) throws Exception {
        //whenever you are loading a single item/entity from the database you want to check whether someone was returned from the database
        //you can do that using the "Optional<>" container and/or you can use an if statement 
        //findById will go to the database and check if an individual car exists with the id that was passed into the method from webpage
        
        Optional<Car> cardetail = carRepository.findById(id);

        if (cardetail == null) {

            throw new Exception("Car not found");
        }

        return cardetail.get();


    }

    public List<Car> findCarsByModel(String model) {
        List<Car> foundCars = carRepository.findByModel(model);

        return foundCars;
    }

    public List<Car> discountCars(List<Car> availableCars){

 //iterate through all the cars passed into the method
      for(Car car: availableCars){

//check how long each car has been in inventory
 //dateofPurchase
 LocalDate startDate = car.getDateOfPurchase();
 LocalDate endDate = LocalDate.now();

 long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

  //if the car has been in inventory for more than 120 days
         if(daysBetween > 120){

            //we are going to apply a 10% discount
             //price
             double currentPrice = car.getPrice();

             double discountedAmount = currentPrice * 0.10;
             double discountedPrice = currentPrice - discountedAmount;

             car.setPrice(discountedPrice);

             //update car in the database with the new price
             carRepository.save(car);

         }

      }

     return availableCars;

  }

  public Car addCar(Car car) {
    Car savedCar = carRepository.save(car);
    return savedCar;
  }

}