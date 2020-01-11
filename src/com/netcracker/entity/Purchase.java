package com.netcracker.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "public", name = "purchase")
public class Purchase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderNumber;

    @Column(name="date")
    private Date date;

    @Column(name="amount")
    private int amount;

    @Column(name="total")
    private double total;

    public Purchase(){}

    public Purchase(Date date, Shop seller, Customer customer, Book book, int amount, double total){
        this.date=date;
        this.seller=seller;
        this.customer=customer;
        this.book=book;
        this.amount=amount;
        this.total=total;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book", nullable = false)
    private Book book;
    public Book getBook() { return book;}
    public void setBook(Book book) {
        this.book = book;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seller", nullable = false)
    private Shop seller;
    public Shop getSeller() {
        return seller;
    }
    public void setSeller(Shop seller) {
        this.seller = seller;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer", nullable = false)
    private Customer customer;
    public Customer getCustomer(){return customer;}
    public void setBook(Customer customer) { this.customer = customer; }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "Purchase[" +
                " orderNumber='" +orderNumber + '\'' +
                ", date='" + date + '\'' +
                ", sellerId=" + seller.getId() +
                ", customerId=" + customer.getId() +
                ", bookId=" + book.getId() +
                ", amount=" + amount +
                ", total=" + total +
                ']';

    }
}
