package org.example.Service;

import org.example.Entity.Alert;
import org.example.Entity.Reading;
import org.example.Entity.Vehicle;
import org.example.Exception.ResourceNotFoundException;
import org.example.Repository.AlertRepository;
import org.example.Repository.VehicleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlertServiceImplementation implements AlertService {

    @Autowired
    AlertRepository repository;
    @Autowired
    VehicleRespository vRepository;

    @Override
    public void checkAlert(Reading reading) {
        Optional<Vehicle> vehiclePresent = vRepository.findByVin(reading.getVin());
        Vehicle vehicle = vehiclePresent.get();
        if(reading.getFuelVolume() < (0.1*vehicle.getMaxFuelVolume())) {
            Alert alert = new Alert();
            alert.setAlertType(1);
            alert.setPriority("medium");
            alert.setReadingId(reading.getId());
            alert.setVehicleId(vehicle.getVin());
            alert.setAlertMessage("Time to refuel the tank");
            Alert savedAlert = create(alert);
        }
        if(reading.getTires().getFrontLeft() < 32 || reading.getTires().getFrontLeft() > 36 ||
                reading.getTires().getFrontRight() < 32 || reading.getTires().getFrontRight() > 36 ||
                reading.getTires().getRearLeft() < 32 || reading.getTires().getRearLeft() > 36 ||
                reading.getTires().getRearRight() < 32 || reading.getTires().getRearRight() > 36) {
            Alert alert = new Alert();
            alert.setAlertType(2);
            alert.setPriority("low");
            alert.setReadingId(reading.getId());
            alert.setVehicleId(vehicle.getVin());
            alert.setAlertMessage("Check the tire pressure");
            Alert savedAlert = create(alert);
        }
        if(reading.isCheckEngineLightOn()) {
            Alert alert = new Alert();
            alert.setAlertType(3);
            alert.setPriority("low");
            alert.setReadingId(reading.getId());
            alert.setVehicleId(vehicle.getVin());
            alert.setAlertMessage("Your engine Light is ON");
            Alert savedAlert = create(alert);
        }
        if(reading.getEngineRpm() > vehicle.getRedlineRpm()) {
            Alert alert = new Alert();
            alert.setAlertType(4);
            alert.setPriority("high");
            alert.setReadingId(reading.getId());
            alert.setVehicleId(vehicle.getVin());
            alert.setAlertMessage("There is a serious problem with the Engine RPM");
            Alert savedAlert = create(alert);
        }
        if(reading.isEngineCoolantLow()) {
            Alert alert = new Alert();
            alert.setAlertType(5);
            alert.setPriority("low");
            alert.setReadingId(reading.getId());
            alert.setVehicleId(vehicle.getVin());
            alert.setAlertMessage("The Engine Coolant is Low");
            Alert savedAlert = create(alert);
        }
    }

    @Override
    public Alert create(Alert alert) {
        return repository.save(alert);
    }

    @Override
    public List<Alert> findHighAlerts() {
        List<Alert> results = (List<Alert>)repository.findAll();
        List<Alert> alerts = new ArrayList<>();
        for(Alert result : results) {
            if(result.getPriority().equals("high"))
                alerts.add(result);
        }
        return alerts;
    }
}
