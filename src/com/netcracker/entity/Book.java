package com.netcracker.entity;

import javax.persistence.*;

@Entity
@Table(schema = "rest", name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="cost")
    private String cost;

    @Column(name="warehouse")
    private String wareHouse;

    @Column(name="amount")
    private String amount;

    public Book(){}

    public Book(String name, String cost, String wareHouse, String amount){
        this.name=name;
        this.cost=cost;
        this.wareHouse=wareHouse;
        this.amount=amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getWareHouse() {
        return wareHouse;
    }

    public void setWareHouse(String wareHouse) {
        this.wareHouse = wareHouse;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
