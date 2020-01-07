package com.netcracker.Service;

import com.netcracker.commands.CustomerForm;
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

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Customer findById(long id){
        Optional<Customer> optional = customerRepository.findById(id);
        return optional.orElse(new Customer());
    }

    public List<Customer> findByFamily(String family){
        return customerRepository.findByFamily(family);
    }

    public List<Customer> findByGeography(String geography){
        return customerRepository.findByFamily(geography);
    }

    public List<Customer> findByDiscount(String discount){
        return customerRepository.findByFamily(discount);
    }

    public void save(Customer customer){
        customerRepository.save(customer);
    }

    public void deleteById(long id){
        customerRepository.deleteById(id);
    }
//    public List<Customer> retrieveByFamily(String family){
//        return customerRepository.retrieveByFamily(family);
//    }






//    List<Customer> listAll();
//
//    Customer getById(Long id);
//
//    Customer saveOrUpdate(Customer customer);
//
//    void delete(Long id);
//
//    Customer saveOrUpdateCustomerForm(CustomerForm productForm);
}





