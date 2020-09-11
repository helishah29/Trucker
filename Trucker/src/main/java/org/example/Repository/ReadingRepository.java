package org.example.Repository;

import org.example.Entity.Reading;
import org.example.Entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReadingRepository extends CrudRepository<Reading, String> {

}
