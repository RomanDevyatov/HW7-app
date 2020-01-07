package com.netcracker.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "rest", name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="order number")
    private String orderNumber;

    @Column(name="date")
    private Date date;

    @Column(name="seller")
    private int sellerId;

    @Column(name="book")
    private int bookId;

    @Column(name="amount")
    private int amount;

    @Column(name="total")
    private double total;

    public Purchase(){}

    private Purchase(String orderNumber, Date date, int sellerId, int bookId, int amount, double total){
        this.orderNumber=orderNumber;
        this.date=date;
        this.sellerId=sellerId;
        this.bookId=bookId;
        this.amount=amount;
        this.total=total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
