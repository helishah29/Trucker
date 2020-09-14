package org.example.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.Entity.Alert;
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

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Finds all the Vehicles registered",
            notes ="Returns a list of all vehicles available in the database")
    public List<Vehicle> findAll() {
        return service.findAll();
    }
}
