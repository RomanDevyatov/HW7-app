package com.netcracker.Controller;

import com.netcracker.Service.CustomerService;
import com.netcracker.commands.CustomerForm;
import com.netcracker.converts.CustomerToCustomerForm;
import com.netcracker.entity.Customer;
import com.netcracker.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        System.out.println("Get all Customers...");

        List<Customer> customers = new ArrayList<>();
        repository.findAll().forEach(customers::add);

        return customers;
    }

    @PostMapping(value = "/customers/create")
    public Customer postCustomer(@RequestBody Customer customer) {

        Customer newCustomer = repository.save(new Customer(customer.getFamily(), customer.getGeography(), customer.getDiscount() ));
        return newCustomer;
    }

//    private CustomerService customerService;
//
//    private CustomerToCustomerForm customerToCustomerForm;
//
//    @Autowired
//    public void setCustomerToCustomerForm(CustomerToCustomerForm customerToCustomerForm) {
//        this.customerToCustomerForm = customerToCustomerForm;
//    }
//
//    @Autowired
//    public void setCustomerService(CustomerService customerService) {
//        this.customerService = customerService;
//    }
//
//    @RequestMapping("/")
//    public String redirToList(){
//        return "redirect:/customer/list";
//    }
//
//    @RequestMapping({"/customer/list", "/customer"})
//    public String listCustomers(Model model){
//        model.addAttribute("customers", customerService.listAll());
//        return "customer/list";
//    }
//
//    @RequestMapping("/customer/show/{id}")
//    public String getCustomer(@PathVariable String id, Model model){
//        model.addAttribute("customer", customerService.getById(Long.valueOf(id)));
//        return "customer/show";
//    }
//
//    @RequestMapping("Customer/edit/{id}")
//    public String edit(@PathVariable String id, Model model){
//        Customer customer = customerService.getById(Long.valueOf(id));
//        CustomerForm customerForm = customerToCustomerForm.convert(customer);
//
//        model.addAttribute("customerForm", customerForm);
//        return "customer/customerform";
//    }
//
//    @RequestMapping("/customer/new")
//    public String newCustomer(Model model){
//        model.addAttribute("customerForm", new CustomerForm());
//        return "resources/templates/customer/customerform";
//    }
//
//    @RequestMapping(value = "/customer", method = RequestMethod.POST)
//    public String saveOrUpdateCustomer(@Valid CustomerForm customerForm, BindingResult bindingResult){
//
//        if(bindingResult.hasErrors()){
//            return "customer/customerform";
//        }
//
//        Customer savedCustomer = customerService.saveOrUpdateCustomerForm(customerForm);
//
//        return "redirect:/customer/show/" + savedCustomer.getId();
//    }
//
//    @RequestMapping("/customer/delete/{id}")
//    public String delete(@PathVariable String id){
//        customerService.delete(Long.valueOf(id));
//        return "redirect:/customer/list";
//    }



}
