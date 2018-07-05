package ru.itpark.service;

import org.springframework.stereotype.Service;


import ru.itpark.entity.AbstractProduct;
import ru.itpark.entity.Product;
import ru.itpark.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(Product Product) {
        productRepository.saveAndFlush(Product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByName(String name){
        return productRepository.findByNameContains(name);
    }
}
