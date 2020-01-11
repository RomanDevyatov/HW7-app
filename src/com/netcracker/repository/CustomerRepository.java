package com.netcracker.repository;

import com.netcracker.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByFamily(String family);
    List<Customer> findByGeography(String geography);
    List<Customer> findByDiscount(double discount);

    void deleteById(long id);

    @Query(value = "SELECT * FROM  customer where customer.family = :family", nativeQuery = true)
    List<Customer> retrieve(@Param("family") String family);


    @Query(value = "select distinct c.geography from customer c", nativeQuery = true)
    List<String> retrieveGeography();

    @Query(value =  "select c.family,c.discount from customer c where c.geography='Нижегородском'", nativeQuery = true)
    List<String> retrieveFamilyDiscount();
}
