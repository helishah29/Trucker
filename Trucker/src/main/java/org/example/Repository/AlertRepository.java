package org.example.Repository;

import org.example.Entity.Alert;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AlertRepository extends CrudRepository<Alert, String> {
}
