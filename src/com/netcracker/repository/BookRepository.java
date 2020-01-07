package com.netcracker.repository;

import com.netcracker.entity.Book;
import com.netcracker.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByName(String name);
    List<Book> findByCost(int cost);
    List<Book> findByWareHouse(String wareHouse);
    List<Book> findByAmount(int amount);
}
