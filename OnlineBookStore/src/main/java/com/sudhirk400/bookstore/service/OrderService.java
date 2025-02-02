/**
 * 
 */
package com.sudhirk400.bookstore.service;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhirk400.bookstore.model.Order;
import com.sudhirk400.bookstore.repository.OrderRepository;

import java.util.List;

 
/**
 * The Class OrderService.
 */
@Service
public class OrderService {

    /** The orders repository. */
    @Autowired
    private OrderRepository ordersRepository;

    /**
     * Gets the all orders.
     *
     * @return the all orders
     */
    public List<Order> getAllOrders() {
        return ordersRepository.findAll();
    }

    /**
     * Gets the order by id.
     *
     * @param id the id
     * @return the order by id
     */
    public Order getOrderById(Integer id) {
        return ordersRepository.findById(id).orElse(null);
    }

    /**
     * Save order.
     *
     * @param order the order
     * @return the order
     */
    public Order saveOrder(Order order) {
        return ordersRepository.save(order);
    }

    /**
     * Delete order by id.
     *
     * @param id the id
     */
    public void deleteOrderById(Integer id) {
        ordersRepository.deleteById(id);
    }
}

