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

@Entity
@Table(name = "mobiles")
public class Mobile extends Product {

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

    @Column(name = "diagonal")
    private String diagonal;

    @Column(name = "memory_gb")
    private String memoryGb;

    @Column(name = "processor_model")
    private String processorModel;

    @Column(name = "battery_power")
    private String batteryPower;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
//    @JoinTable(name = "order_mobile",
//            joinColumns = @JoinColumn(name = "mobile_id"),
//            inverseJoinColumns = @JoinColumn(name = "order_id"))
//    private List<Order> orders;


    public Mobile() {
    }

    public Mobile(int id, String name, String description, int quantity, int price, String diagonal, String memoryGb, String processorModel, String batteryPower, Account account) {
        super(id, name, description, quantity, price, account);
        this.diagonal = diagonal;
        this.memoryGb = memoryGb;
        this.processorModel = processorModel;
        this.batteryPower = batteryPower;
    }

    public String getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(String diagonal) {
        this.diagonal = diagonal;
    }

    public String getMemoryGb() {
        return memoryGb;
    }

    public void setMemoryGb(String memoryGb) {
        this.memoryGb = memoryGb;
    }

    public String getProcessorModel() {
        return processorModel;
    }

    public void setProcessorModel(String processorModel) {
        this.processorModel = processorModel;
    }

    public String getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(String batteryPower) {
        this.batteryPower = batteryPower;
    }
}
