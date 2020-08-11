package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Order;

public interface OrderService {
    Order findByOrdnum(long id);

    Order save(Order order);
}
