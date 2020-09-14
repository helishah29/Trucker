package org.example.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.Entity.Alert;
import org.example.Service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "alerts")
@Api(description = "Aletrs Related endpoint")
public class AlertController {
    @Autowired
    private AlertService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Finds all the high Alerts",
            notes ="Returns a list of all high priority alerts available in the database")
    public List<Alert> findHighAlerts() {
        return service.findHighAlerts();
    }
}
