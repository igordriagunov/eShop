package ru.itpark.entity;

import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product extends AbstractProduct {

    public Product(int id, String name, String description, int quantity, int price) {
        super(id, name, description, quantity, price);
    }

    public Product() {
    }
}
