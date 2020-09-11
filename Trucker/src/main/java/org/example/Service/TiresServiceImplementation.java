package org.example.Service;

import org.example.Entity.Tires;
import org.example.Entity.Vehicle;
import org.example.Repository.TiresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiresServiceImplementation implements TiresService{

    @Autowired
    TiresRepository repository;

    @Override
    public Tires create(Tires tires) {
        return repository.save(tires);
    }
}
