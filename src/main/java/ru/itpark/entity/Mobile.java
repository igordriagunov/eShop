package ru.itpark.entity;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    Account account;

    public Mobile(int id, String name, String description, int quantity, int price, String diagonal, int memoryGb, String processorModel, int batteryPower, Account account ) {
        super(id, name, description, quantity, price, account);
        this.diagonal = diagonal;
        this.memoryGb = memoryGb;
        this.processorModel = processorModel;
        this.batteryPower = batteryPower;
    }

    public Mobile() {
    }


}
