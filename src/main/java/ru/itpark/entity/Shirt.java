package ru.itpark.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "shirts")
public class Shirt extends Product {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @Column(name = "description", nullable = false)
//    private String description;
//
//    @Column(name = "quantity", nullable = false)
//    private int quantity;
//
//    @Column(name = "price", nullable = false)
//    private int price;

    @Column(name = "size")
    private String size;

    @Column(name = "color")
    private String color;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
//    @JoinTable(name = "order_shirt",
//            joinColumns = @JoinColumn(name = "shirt_id"),
//            inverseJoinColumns = @JoinColumn(name = "order_id"))
//    private List<Order> orders;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
//    @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "FK_accountId"))
//    private Account account;

    public Shirt() {
    }

    public Shirt(int id, String name, String description, int quantity, int price, String size, String color, Account account) {
        super(id, name, description, quantity, price, account);
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
