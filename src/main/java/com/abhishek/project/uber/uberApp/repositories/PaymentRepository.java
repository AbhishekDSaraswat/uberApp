package com.abhishek.project.uber.uberApp.repositories;

import com.abhishek.project.uber.uberApp.entities.Payment;
import com.abhishek.project.uber.uberApp.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {

   Optional<Payment>  findByRide(Ride ride);
}