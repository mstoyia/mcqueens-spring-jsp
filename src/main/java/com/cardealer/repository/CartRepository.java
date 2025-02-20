package com.cardealer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cardealer.models.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    
}
