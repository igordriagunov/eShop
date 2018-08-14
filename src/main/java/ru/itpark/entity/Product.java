package ru.itpark.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Product extends ProductDetail  {

    public Product() {
    }

    public Product(String name, String description, int quantity, int price, Account account) {
        super(name, description, quantity, price, account);
    }
}

