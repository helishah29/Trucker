package org.example.Repository;

import org.example.Entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VehicleRespository extends CrudRepository<Vehicle, String> {
    Optional<Vehicle> findByVin(String vin);
}
