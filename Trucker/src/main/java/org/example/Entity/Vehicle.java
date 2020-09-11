package org.example.Entity;

//        "vin": "1HGCR2F3XFA027534",
//        "make": "HONDA",
//        "model": "ACCORD",
//        "year": 2015,
//        "redlineRpm": 5500,
//        "maxFuelVolume": 15,
//        "lastServiceDate": "2017-05-25T17:31:25.268Z"

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Vehicle {
    @Id
    @Column(columnDefinition = "VARCHAR(50)")
    private String id;
    @Column(unique = true)
    private String vin;
    private String make;
    private String model;
    private int year;
    private int redlineRpm;
    private int maxFuelVolume;
    private Date lastServiceDate;

    public Vehicle() { this.id = UUID.randomUUID().toString(); }

    public void setId(String id) {
        this.id = id;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public void setMaxFuelVolume(int maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public void setLastServiceDate(Date lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public String getId() {
        return id;
    }

    public String getVin() {
        return vin;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public int getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public Date getLastServiceDate() {
        return lastServiceDate;
    }
}
