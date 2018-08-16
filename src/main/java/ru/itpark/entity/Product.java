package ru.itpark.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product extends ProductDetail {

    public Product() {
    }

    public Product(int id, String name, String description, int quantity, int price, Account account) {
        super(id, name, description, quantity, price, account);
    }
}

