package org.example.Controller;

import io.swagger.annotations.Api;
import org.example.Entity.Reading;
import org.example.Entity.Tires;
import org.example.Service.ReadingService;
import org.example.Service.TiresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "readings")
@Api(description = "Reading information related endpoint -- contains all the information about the live readings")
public class ReadingController {
    @Autowired
    private ReadingService service;
    @Autowired
    private TiresService tService;

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading create(@RequestBody Reading reading) {
        Tires tire = reading.getTires();
        Tires savedInstance = tService.create(tire);
        return service.create(reading);
    }

}
