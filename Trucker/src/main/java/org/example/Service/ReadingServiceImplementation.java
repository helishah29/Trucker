package org.example.Service;

import org.example.Entity.Alert;
import org.example.Entity.Reading;
import org.example.Entity.Vehicle;
import org.example.Exception.ResourceNotFoundException;
import org.example.Repository.ReadingRepository;
import org.example.Repository.VehicleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReadingServiceImplementation implements ReadingService{
    @Autowired
    ReadingRepository repository;
    @Autowired
    VehicleRespository vRepository;
    @Autowired
    AlertService aService;

    @Override
    public Reading create(Reading reading) {
        Optional<Vehicle> vehicle = vRepository.findByVin(reading.getVin());
        if(!vehicle.isPresent()) {
            throw new ResourceNotFoundException("Vehicle with given ID NOT FOUND");
        }
        aService.checkAlert(reading);
        return repository.save(reading);
    }
}
