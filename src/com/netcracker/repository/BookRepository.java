package com.netcracker.repository;

import com.netcracker.entity.Book;
import com.netcracker.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByName(String name);
    List<Book> findByCost(int cost);
    List<Book> findByWareHouse(String wareHouse);
    List<Book> findByAmount(int amount);


//    @Query(value = "select distinct name, cost from book;", nativeQuery = true)
//    List<String> getNameCost(@Param("name") String name,
//                           );

    @Query(value = "select distinct name,cost from book", nativeQuery = true)
    List<String> retrieveNameCost();

    @Query(value = "select b.name,b.cost from book b where b.name like '%Windows%' or b.cost >20000 order by 1, 2 desc", nativeQuery = true)
    List<String> retrieveNameLikeWindows();
}
