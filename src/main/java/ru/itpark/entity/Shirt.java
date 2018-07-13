package ru.itpark.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "shirts")
public class Shirt extends Product {

    @Column(name = "size")
    private String size;

    @Column(name = "color")
    private String color;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
//    @JoinColumn(name = "accountId")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Account account;


    public Shirt(int id, String name, String description, int quantity, int price, String size, String color, Account account) {
        super(id, name, description, quantity, price);
        this.size = size;
        this.color = color;
    }

    public Shirt() {
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
