package com.netcracker.entity;

import javax.persistence.*;

@Entity
@Table(schema = "rest", name= "customer")
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

    public Customer(){}

    public Customer(String family, String geography, double discount) {
        this.family=family;
        this.geography=geography;
        this.discount=discount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
