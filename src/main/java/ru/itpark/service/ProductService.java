package ru.itpark.service;

import org.springframework.stereotype.Service;
import ru.itpark.entity.Product;
import ru.itpark.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(Product product) {
        productRepository.saveAndFlush(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

}
