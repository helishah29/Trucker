package org.example.Controller;

import io.swagger.annotations.Api;
import org.example.Entity.Vehicle;
import org.example.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "vehicles")
@Api(description = "Vehicle information related endpoint -- contains all the information about a vehicle")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> update(@RequestBody List<Vehicle> vehicles){
        for(Vehicle vehicle : vehicles)
            service.update(vehicle);
        return vehicles;
    }
}
