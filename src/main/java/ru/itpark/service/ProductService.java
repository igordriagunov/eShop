package ru.itpark.service;

import org.springframework.stereotype.Service;
import ru.itpark.entity.Account;
import ru.itpark.entity.Mobile;
import ru.itpark.entity.Product;
import ru.itpark.repository.MobileRepository;
import ru.itpark.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public void saveProduct(Product product) {
        productRepository.saveAndFlush(product);
    }

    public Product save(int id, String name, String description, int quantity, int price, String diagonal,
                        String memoryGb, String processorModel, String batteryPower) {

        Product mobile = new Mobile(
                id,
                name,
                description,
                quantity,
                price,
                diagonal,
                memoryGb,
                processorModel,
                batteryPower,
                new Account()
        );

        return productRepository.saveAndFlush(mobile);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByName(String name) {
        return productRepository.findByNameContains(name);
    }

    public List<Product> findAllByAccountId(int accountId) {
        return productRepository.findAllByAccount_Id(accountId);
    }

    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }


    //    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }


}
