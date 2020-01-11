package com.netcracker.service;

import com.netcracker.entity.Book;
import com.netcracker.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findById(long id){
        Optional<Book> optional = bookRepository.findById(id);
        return optional.orElse(new Book());
    }

    public List<Book> findByName(String name){ return bookRepository.findByName(name); }

    public List<Book> findByCost(int cost){
        return bookRepository.findByCost(cost);
    }

    public List<Book> findByWarehouse(String wareHouse){
        return bookRepository.findByWareHouse(wareHouse);
    }

    List<Book> findByAmount(int amount) {return bookRepository.findByAmount(amount); }

    //public void save(Book book){
//        bookRepository.save(book);
//    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }

    public Book save(Book book){
        bookRepository.save(book);
        return book;
    }

    public void deleteById(long id){
        bookRepository.deleteById(id);
    }

    public List<String> retrieveNameCost(){
        return bookRepository.retrieveNameCost();
    }

    public List<String> retrieveNameLikeWindows(){
        return bookRepository.retrieveNameLikeWindows();
    }
}
