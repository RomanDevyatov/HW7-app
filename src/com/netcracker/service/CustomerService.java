package com.netcracker.service;

import com.netcracker.entity.Customer;
import com.netcracker.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService  {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll(){ return customerRepository.findAll(); }

    public Customer findById(long id){
        Optional<Customer> optional = customerRepository.findById(id);
        return optional.orElse(new Customer());
    }

    public List<Customer> findByFamily(String family){
        return customerRepository.findByFamily(family);
    }

    public List<Customer> findByGeography(String geography){ return customerRepository.findByGeography(geography); }

    public List<Customer> findByDiscount(double discount){ return customerRepository.findByDiscount(discount);   }

    public Customer save(Customer customer){
        customerRepository.save(customer);
        return customer;
    }

    public void deleteById(long id){ customerRepository.deleteById(id);   }

    public void deleteAll() { customerRepository.deleteAll(); }

    public List<Customer> retrieveByFamily(String family){
        return customerRepository.retrieve(family);
    }
    public List<String> retrieveGeography(){
        return customerRepository.retrieveGeography();
    }

    public List<String> retrieveFamilyDiscount() {
        return customerRepository.retrieveFamilyDiscount();
    }
}





