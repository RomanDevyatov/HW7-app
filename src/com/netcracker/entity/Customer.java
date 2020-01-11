package com.netcracker.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(schema = "public", name= "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="family")
    private String family;
    @Column(name="geography")
    private String geography;
    @Column(name="discount")
    private double discount;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Purchase> purchases;
    public Set<Purchase> getPurchases(){
        return purchases;
    }
    public void setPurchases(Set<Purchase> purchases) { this.purchases = purchases; }

    public Customer(){}

    public Customer(String family, String geography, double discount) {
        this.family=family;
        this.geography=geography;
        this.discount=discount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {  this.id = id; }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGeography() {
        return geography;
    }

    public void setGeography(String geography) {
        this.geography = geography;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Customer[" +
                "id=" + id +
                ", family='" + family + '\'' +
                ", geography='" + geography + '\'' +
                ", discount=" + discount +
                ']';
    }

}
