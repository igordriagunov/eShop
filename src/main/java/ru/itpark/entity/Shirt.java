package ru.itpark.entity;

import javax.persistence.*;

@Entity
@Table(name = "shirts")
public class Shirt extends Product {

    @Column(name = "size")
    private String size;

    @Column(name = "color")
    private String color;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    Account account;

    public Shirt(int id, String name, String description, int quantity, int price, String size, String color, Account account ) {
        super(id, name, description, quantity, price, account);
        this.size = size;
        this.color = color;
    }

    public Shirt() {
    }
}
