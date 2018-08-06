package ru.itpark.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "date")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String date = new java.util.Date().toString();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE  )
    @JoinTable(name = "order_mobile",
            joinColumns = @JoinColumn(name = "order_id",foreignKey = @ForeignKey(name = "FK_orderId_mobileId")),
            inverseJoinColumns = @JoinColumn(name = "mobile_id"))
    private Mobile mobile;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "order_shirt",
            joinColumns = @JoinColumn(name = "order_id",foreignKey = @ForeignKey(name = "FK_orderId_shirtId")),
            inverseJoinColumns = @JoinColumn(name = "shirt_id"))
    private Shirt shirt;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "FK_accountId"))
    private Account account;
}
