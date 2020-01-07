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
    List<Customer> findByDiscount(String discount);

    void deleteById(long id);

//    @Query(value = "SELECT * FROM  customer c WHERE c.family = :family", nativeQuery = true)
//    List<Customer> retrieveByFamily(@Param("family") String family);

}
