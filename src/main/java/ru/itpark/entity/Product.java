//package ru.itpark.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//
//import javax.persistence.*;
//
//@MappedSuperclass
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Product {
//
//    @Id
//    @GeneratedValue
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
//
//
//    //    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
////    @JoinColumn(name = "accountId", nullable = false, foreignKey = @ForeignKey(name = "FK_accountId"))
////    @OnDelete(action = OnDeleteAction.CASCADE)
////    private Account account;
//
////    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,optional = false)
////    @JoinColumn(name = "account_accountId")
////    private Account account;
//
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//}
//
