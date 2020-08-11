package com.lambdaschool.javaorders.controllers;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    // http://localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> listAllOrders(){
        List<Customer> orders = customerService.findAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    // http://localhost:2019/customers/customer/7
    @GetMapping(value = "/customer/{id}", produces = "application/json")
    public ResponseEntity<?> findCustomerById(@PathVariable long id){
        Customer myCustomer = customerService.findCustomerById(id);
        return new ResponseEntity<>(myCustomer, HttpStatus.OK);
    }
    // http://localhost:2019/customers/namelike/mes
    @GetMapping(value = "/namelike/{custname}", produces = "application/json")
    public ResponseEntity<?> findByNameLike(@PathVariable String custname){
        List<Customer> list = customerService.findByNameLike(custname);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
