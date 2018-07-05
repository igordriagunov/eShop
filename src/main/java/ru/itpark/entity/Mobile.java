package ru.itpark.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mobiles")
public class Mobile extends Product {

    @Column(name = "diagonal", nullable = false)
    private String diagonal;

    @Column(name = "memoryGb", nullable = false)
    private int memoryGb;

    @Column(name = "processorModel", nullable = false)
    private String processorModel;

    @Column(name = "batteryPower", nullable = false)
    private int batteryPower;

    public Mobile(int id, String name, String description, int quantity, int price, String diagonal, int memoryGb, String processorModel, int batteryPower) {
        super(id, name, description, quantity, price);
        this.diagonal = diagonal;
        this.memoryGb = memoryGb;
        this.processorModel = processorModel;
        this.batteryPower = batteryPower;
    }

    public Mobile() {
    }
}
