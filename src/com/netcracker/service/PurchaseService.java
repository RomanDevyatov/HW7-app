package com.netcracker.service;

import com.netcracker.entity.Purchase;
import com.netcracker.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> findAll(){
        return purchaseRepository.findAll();
    }

    public Purchase findById(long id){
        Optional<Purchase> optional = purchaseRepository.findById(id);
        return optional.orElse(new Purchase());
    }

    public List<Purchase> findByOrderNumber(String orderNumber){
        return purchaseRepository.findByOrderNumber(orderNumber);
    }

    public List<Purchase> findByDate(Date date){
        return purchaseRepository.findByDate(date);
    }

    public List<Purchase> findBySeller(int sellerId){
        return purchaseRepository.findBySeller(sellerId);
    }
    public List<Purchase> findByCustomer(int customerId){
        return purchaseRepository.findBySeller(customerId);
    }

    public List<Purchase> findByBook(int bookId){
        return purchaseRepository.findByBook(bookId);
    }
    public List<Purchase> findByAmount(int amount){
        return purchaseRepository.findByAmount(amount);
    }
    public List<Purchase> findByTotal(double total){
        return purchaseRepository.findByTotal(total);
    }

    public void save(Purchase purchase){
        purchaseRepository.save(purchase);
    }

    public void deleteById(long id){
        purchaseRepository.deleteById(id);
    }

    public void deleteAll() {
        purchaseRepository.deleteAll();
    }

    public List<Date> retrieveDate(){
        return purchaseRepository.retrieveDate();
    }

    public List<String> retrieveDateFamilyDiscountNameAmount() {
        return purchaseRepository.retrieveDateFamilyDiscountNameAmount();
    }
}
