package ru.itpark.service;

import org.springframework.stereotype.Service;
import ru.itpark.entity.Shirt;
import ru.itpark.repository.ShirtRepository;

import java.util.List;

//import ru.itpark.entity.Product;

@Service
public class ShirtService {

    private final ShirtRepository shirtRepository;

    public ShirtService(ShirtRepository shirtRepository) {
        this.shirtRepository = shirtRepository;
    }

    public void save(Shirt shirt) {
        shirtRepository.saveAndFlush(shirt);
    }

    public List<Shirt> findAll() {
        return shirtRepository.findAll();
    }

    public List<Shirt> findByName(String name){
        return shirtRepository.findByNameContains(name);
    }
}