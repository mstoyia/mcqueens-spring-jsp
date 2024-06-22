package com.cardealer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cardealer.models.Car;

@Repository
public interface CarRepository extends JpaRepository <Car, Long> {
    //this will do a select statement on the car and return any cars with the given model
    @Query(value = "select * from car where model = ?1", nativeQuery=true)
    public List<Car> findByModel(String model);
}


// FOR LOADING ALL CARS IN DATABASE (AVAILABLE CARS PAGE)
// 7
// findAll():Iterable< Employee >
// returns all the entities.

// 9
// findById(Integer id):Optional< Employee >
// returns an entity identified using id.
