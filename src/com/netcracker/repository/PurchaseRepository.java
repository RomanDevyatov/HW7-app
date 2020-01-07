package com.netcracker.repository;

import com.netcracker.entity.Purchase;
import com.netcracker.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> findByOrderNumber(String orderNumber);
    List<Purchase> findByDate(Date date);
    List<Purchase> findBySellerId(int sellerId);
    List<Purchase> findByBookId(int bookId);
    List<Purchase> findByAmount(int amount);
    List<Purchase> findByTotal(double total);

    void deleteById(long id);
}
