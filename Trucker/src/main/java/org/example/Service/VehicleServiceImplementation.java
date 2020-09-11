package org.example.Service;

import org.example.Entity.Vehicle;
import org.example.Repository.VehicleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImplementation implements VehicleService{

    @Autowired
    VehicleRespository repository;

    @Override
    @Transactional
    public Vehicle update(Vehicle vehicle) {
        return repository.save(vehicle);
    }
}

