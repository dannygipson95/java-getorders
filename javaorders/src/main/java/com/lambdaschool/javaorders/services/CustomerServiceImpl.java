package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerrepos;

    @Override
    public List<Customer> findAllOrders() {
        List<Customer> allOrders = new ArrayList<>();
        customerrepos.findAll().iterator().forEachRemaining(allOrders::add);
        return allOrders;
    }

    @Override
    public Customer findCustomerById(long id) {
        return customerrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer " + id + " Not Found!"));
    }

    @Override
    public List<Customer> findByNameLike(String custname) {
        List<Customer> list = new ArrayList<>();
        customerrepos.findByCustnameContainingIgnoringCase(custname).iterator().forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        return customerrepos.save(customer);
    }
}