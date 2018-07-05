package ru.itpark.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shirts")
public class Shirt extends Product {

    @Column(name = "size", nullable = false)
    private String size;

    @Column(name = "color", nullable = false)
    private String color;

    public Shirt(int id, String name, String description, int quantity, int price, String size, String color) {
        super(id, name, description, quantity, price);
        this.size = size;
        this.color = color;
    }

    public Shirt() {
    }
}
