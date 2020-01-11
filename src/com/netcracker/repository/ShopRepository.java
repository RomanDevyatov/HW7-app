package com.netcracker.repository;

import com.netcracker.entity.Customer;
import com.netcracker.entity.Purchase;
import com.netcracker.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    List<Shop> findByName(String name);
    List<Shop> findByArea(String area);
    List<Shop> findByCommission(int commission);
///[pkpk

    @Query(value = "select c.name from shop c where c.area=:ar1 or c.area=:ar2", nativeQuery = true)
    List<String> retrieveNameWhereAreaOr(@Param("ar1") String area1,
                                         @Param("ar2")String area2);
}
