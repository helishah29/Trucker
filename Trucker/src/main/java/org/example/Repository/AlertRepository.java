package org.example.Repository;

import org.example.Entity.Alert;
import org.springframework.data.repository.CrudRepository;

public interface AlertRepository extends CrudRepository<Alert, String> {
}
