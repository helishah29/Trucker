package org.example.Entity;
import org.example.Entity.Vehicle;
import javax.persistence.*;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

//{
//        "vin": "1HGCR2F3XFA027534",
//        "latitude": 41.803194,
//        "longitude": -88.144406,
//        "timestamp": "2017-05-25T17:31:25.268Z",
//        "fuelVolume": 1.5,
//        "speed": 85,
//        "engineHp": 240,
//        "checkEngineLightOn": false,
//        "engineCoolantLow": true,
//        "cruiseControlOn": true,
//        "engineRpm": 6300,
//        "tires": {
//        "frontLeft": 34,
//        "frontRight": 36,
//        "rearLeft": 29,
//        "rearRight": 34
//        }
//}



@SuppressWarnings("JpaAttributeTypeInspection")
@Entity
public class Reading {
    @Id
    @Column(columnDefinition = "VARCHAR(50)")
    private String id;

    private String vin;

    private float latitude;
    private float longitude;
    private Date timestamp;
    private float fuelVolume;
    private int speed;
    private int engineHp;
    private boolean checkEngineLightOn;
    private boolean engineCoolantLow;
    private boolean cruiseControlOn;
    private int engineRpm;
    // private Map<String, Integer> tires;

    @OneToOne
    private Tires tires;

    public Reading() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getVin() {
        return vin;
    }

    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public float getFuelVolume() {
        return fuelVolume;
    }

    public int getSpeed() {
        return speed;
    }

    public int getEngineHp() {
        return engineHp;
    }

    public boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public int getEngineRpm() {
        return engineRpm;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public void setVehicle(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setFuelVolume(float fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setEngineHp(int engineHp) {
        this.engineHp = engineHp;
    }

    public void setCheckEngineLightOn(boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public void setCruiseControlOn(boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public void setEngineRpm(int engineRpm) {
        this.engineRpm = engineRpm;
    }
}
