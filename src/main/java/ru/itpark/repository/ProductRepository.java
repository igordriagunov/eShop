package ru.itpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itpark.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Integer> {


    List<Product> findByNameContains(String name);
}
