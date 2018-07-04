package ru.itpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.itpark.entity.Product;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Integer> {
}
