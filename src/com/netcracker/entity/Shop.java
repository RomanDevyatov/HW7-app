package com.netcracker.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "public", name="shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="area")
    private String area;

    @Column(name="commission")
    private int commission;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Purchase> purchases;

    public List<Purchase> getPurchases(){
        return purchases;
    }
    public void setPurchases(List<Purchase> purchases) { this.purchases = purchases; }


    public Shop() {
    }

    public Shop(String name, String area, int commission){
        this.name=name;
        this.area=area;
        this.commission=commission;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return "Shop[" +
                "id=" + id +
                ", name=" + name +
                ", area=" + area +
                ", commission=" + commission +
                ']';
    }
}
