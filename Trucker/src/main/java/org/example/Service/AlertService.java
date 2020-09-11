package org.example.Service;

import org.example.Entity.Alert;
import org.example.Entity.Reading;
import org.example.Entity.Tires;
import org.example.Entity.Vehicle;

public interface AlertService {
    void checkAlert(Reading reading);
    Alert create(Alert alert);
}
