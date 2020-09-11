package org.example.Repository;

import org.example.Entity.Tires;
import org.springframework.data.repository.CrudRepository;

public interface TiresRepository extends CrudRepository<Tires, String> {
}
