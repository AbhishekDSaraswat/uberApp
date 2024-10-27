package com.abhishek.project.uber.uberApp.strategies;

import com.abhishek.project.uber.uberApp.entities.Driver;
import com.abhishek.project.uber.uberApp.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {

    List<Driver> findMatchingDriver(RideRequest rideRequest);

}
