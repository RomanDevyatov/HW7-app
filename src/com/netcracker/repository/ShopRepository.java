package com.netcracker.repository;

import com.netcracker.entity.Customer;
import com.netcracker.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    List<Customer> findByName(String name);
    List<Customer> findByArea(String area);
    List<Customer> findByCommission(int commission);
}
