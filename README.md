# Trucker
 Trucker -- A Spring Boot Application that allows Truckers to track the health of their vehicles while on the move

# Endpoints
PUT http://localhost:8080/api/vehicles

---Puts the vehicles and model information in the DB

GET http://localhost:8080/api/vehicles

-- Fetch details of all the vehicles like VIN, make, model, year etc.

POST http://localhost:8080/api/readings

-- Readings, of every vehicle, is ingested in the DB through this endpoint

Every reading is checked for the following alerts with different priorities:
Following Alerts are enabled:

Rule: engineRpm > readlineRpm, Priority: HIGH
Rule: fuelVolume < 10% of maxFuelVolume, Priority: MEDIUM
Rule: tire pressure of any tire < 32psi || > 36psi , Priority: LOW
Rule: engineCoolantLow = true || checkEngineLightOn = true, Priority: LOW

GET http://localhost:8080/api/alerts

-- Fetch details of all high priority alerts
