package com.netcracker.converts;

import com.netcracker.commands.CustomerForm;
import com.netcracker.entity.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerForm implements Converter<Customer, CustomerForm> {

    @Override
    public CustomerForm convert(Customer customer) {
        CustomerForm customerForm = new CustomerForm();
        customerForm.setId(customer.getId());
        customerForm.setGeography(customer.getGeography());
        customerForm.setFamily(customer.getFamily());
        customerForm.setDiscount(customer.getDiscount());
        return customerForm;
    }
}
