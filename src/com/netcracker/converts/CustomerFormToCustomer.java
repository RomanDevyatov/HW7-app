package com.netcracker.converts;

import com.netcracker.commands.CustomerForm;
import com.netcracker.entity.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CustomerFormToCustomer implements Converter<CustomerForm, Customer> {
    
    @Override
    public Customer convert(CustomerForm customerForm) {
        Customer customer = new Customer();
        if (customerForm.getId() != null  && !StringUtils.isEmpty(customerForm.getId())) {
            customer.setId(new Long(customerForm.getId()));
        }
        customer.setFamily(customerForm.getFamily());
        customer.setDiscount(customerForm.getDiscount());
        customer.setGeography(customerForm.getGeography());
        return customer;
    }
}