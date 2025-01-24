/**
 * 
 */
package com.sudhirk400.bookstore.service;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhirk400.bookstore.model.Order;
import com.sudhirk400.bookstore.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository ordersRepository;

    public List<Order> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Order getOrderById(Integer id) {
        return ordersRepository.findById(id).orElse(null);
    }

    public Order saveOrder(Order order) {
        return ordersRepository.save(order);
    }

    public void deleteOrderById(Integer id) {
        ordersRepository.deleteById(id);
    }
}

