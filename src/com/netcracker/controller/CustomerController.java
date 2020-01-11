package com.netcracker.controller;

import com.netcracker.service.CustomerService;
import com.netcracker.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
//        List<Customer> customers = new ArrayList<>();
//        .forEach(customers::add); //printing
        //customers=customerService.findAll();
        //return new ResponseEntity<List<Customer>>(customerService.findAll(), HttpStatus.OK);
        return customerService.findAll();

    }

    @PostMapping("/customers/create")
    public Customer postCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.save(new Customer(customer.getFamily(), customer.getGeography(), customer.getDiscount() ));
        return newCustomer;
    }

    @DeleteMapping("/customers/delete/{id}")
    public void deleteCustomer(@PathVariable("id") long id){
        //customerService.deleteById(id);
        //return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/customers/{id}")
    public List<Customer> getCustomer(@PathVariable("id") long id,
                                      @RequestBody Customer customer){
        Optional<Customer> customerData = Optional.ofNullable(customerService.findById(id));

        if (customerData.isPresent()){
            Customer newCustomer=customerData.get();
            newCustomer.setFamily(customer.getFamily());
            newCustomer.setGeography(customer.getGeography());
            newCustomer.setDiscount(customer.getDiscount());

            return (List<Customer>) new ResponseEntity<Customer>(customerService.save(newCustomer), HttpStatus.OK);
        } else return (List<Customer>) new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/customers/delete")
    public void deleteAllCustomers() {
        customerService.deleteAll();

        //return new ResponseEntity<>("All customers have been deleted!", HttpStatus.OK);
    }











//    @GetMapping("/customers")
//    public List<Customer> getAllCustomers() {
//        System.out.println("Get all Customers...");
//
//        List<Customer> customers = new ArrayList<>();
//        customerRepository.findAll().forEach(customers::add);
//        return customers;
//    }

//    @PostMapping(value = "/customers/create")
//    public Customer postCustomer(@RequestBody Customer customer) {
//
//        Customer newCustomer = repository.save(new Customer(customer.getFamily(), customer.getGeography(), customer.getDiscount() ));
//        return newCustomer;
//    }

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




}
