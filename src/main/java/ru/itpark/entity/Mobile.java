package ru.itpark.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mobiles")
public class Mobile extends Product{

    @Column(name = "diagonal")
    private String diagonal;

    @Column(name = "memoryGb")
    private int memoryGb;

    @Column(name = "processorModel")
    private String processorModel;

    @Column(name = "batteryPower")
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
