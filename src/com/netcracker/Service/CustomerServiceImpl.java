package com.netcracker.Service;

import com.netcracker.commands.CustomerForm;
import com.netcracker.converts.CustomerFormToCustomer;
import com.netcracker.entity.Customer;
import com.netcracker.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl {
//    private CustomerRepository customerRepository;
//    private CustomerFormToCustomer customerFormToCustomer;
//
//    @Autowired
//    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerFormToCustomer customerFormToCustomer){
//        this.customerFormToCustomer=customerFormToCustomer;
//        this.customerRepository=customerRepository;
//    }
//
//    @Override
//    public List<Customer> listAll(){
//        List<Customer> customers=new ArrayList<>();
//        customerRepository.findAll().forEach(customers::add);
//        return customers;
//    }
//
//    @Override
//    public Customer getById(Long id){
//        return customerRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public Customer saveOrUpdate(Customer customer){
//        customerRepository.save(customer);
//        return customer;
//    }
//
//    @Override
//    public void delete(Long id){
//        customerRepository.deleteById(id);
//    }
//
//
//    @Override
//    public Customer saveOrUpdateCustomerForm(CustomerForm customerForm){
//        Customer savedCustomer=saveOrUpdate(customerFormToCustomer.convert(customerForm));
//
//        System.out.println("Saved Customer Id: "+savedCustomer.getId());
//        return savedCustomer;
//    }
}
