package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository orderrepos;

    @Override
    public Order findByOrdnum(long id) {
        Order myorder = orderrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order " + id + " Not Found!"));
        return myorder;
    }

    @Override
    public Order save(Order order) {
        return orderrepos.save(order);
    }
}
