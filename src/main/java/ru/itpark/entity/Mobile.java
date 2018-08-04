package ru.itpark.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mobiles")
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "diagonal", nullable = false)
    private String diagonal;

    @Column(name = "memory_gb", nullable = false)
    private String memoryGb;

    @Column(name = "processor_model", nullable = false)
    private String processorModel;

    @Column(name = "battery_power", nullable = false)
    private String batteryPower;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
//    @JoinTable(name = "order_mobile",
//            joinColumns = @JoinColumn(name = "mobile_id"),
//            inverseJoinColumns = @JoinColumn(name = "order_id"))
//    private List<Order> orders;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "FK_accountId"))
    private Account account;

}
