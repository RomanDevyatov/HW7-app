package com.netcracker.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "public", name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="cost")
    private int cost;

    @Column(name="warehouse")
    private String wareHouse;

    @Column(name="amount")
    private int amount;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Purchase> purchases;

    public List<Purchase> getPurchases(){
        return purchases;
    }
    public void setPurchases(List<Purchase> purchases) { this.purchases = purchases; }


    public Book(){}

    public Book(String name, int cost, String wareHouse, int amount){
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getWareHouse() {
        return wareHouse;
    }

    public void setWareHouse(String wareHouse) {
        this.wareHouse = wareHouse;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Book[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost='" + cost + '\'' +
                ", warehouse=" + wareHouse +
                ']';
    }
}
