/**
 * 
 */
package com.sudhirk400.bookstore.service;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhirk400.bookstore.model.Cart;
import com.sudhirk400.bookstore.model.Customer;
import com.sudhirk400.bookstore.model.Order;
import com.sudhirk400.bookstore.repository.BookRepository;
import com.sudhirk400.bookstore.repository.CustomerRepository;
import com.sudhirk400.bookstore.repository.OrderItemRepository;
import com.sudhirk400.bookstore.repository.OrderRepository;

import jakarta.transaction.Transactional;

import java.util.Date;
import java.util.List;

 
/**
 * The Class OrderService.
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Gets the all orders.
     *
     * @return the all orders
     */
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Gets the order by id.
     *
     * @param id the id
     * @return the order by id
     */
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    /**
     * Save order.
     *
     * @param order the order
     * @return the order
     */
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    /**
     * Delete order by id.
     *
     * @param id the id
     */
    public void deleteOrderById(Integer id) {
    	orderRepository.deleteById(id);
    }
    
    
    @Transactional
    public Order createOrderFromCart(Cart cart, int customerID) {
        // Fetch customer from DB
        Customer customer = customerRepository.findById(customerID)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (cart.getItems().isEmpty()) {
            throw new RuntimeException("Cart is empty!");
        }
        
        // Create a new Order
        Order order = new Order();
        /*
        order.setCustomerID(customerID);
        order.setOrderDate(new Date());
        order.setStatus("Pending"); // Initial status
        order.setSubtotal(calculateSubtotal(cart));

        // Calculate total (e.g., adding shipping cost)
        double shippingCost = 50.0; // Fixed shipping for now
        order.setShipping(shippingCost);
        order.setTotal(order.getSubtotal() + shippingCost);

        // Save order first to generate orderID
        order = orderRepository.save(order);

        // Convert CartItems to OrderItems
        List<OrderItem> orderItems = cart.getItems().values().stream().map(cartItem -> {
            Book book = cartItem.getBook();

            // Check stock availability
            if (book.getStockLevelNew() < cartItem.getQuantity()) {
                throw new RuntimeException("Not enough stock for book: " + book.getTitle());
            }

            // Deduct stock
            book.setStockLevelNew(book.getStockLevelNew() - cartItem.getQuantity());
            bookRepository.save(book);

            // Create OrderItem
            return new OrderItem(order, book, cartItem.getQuantity(), book.getPrice());
        }).collect(Collectors.toList());

        // Save all OrderItems
        orderItemRepository.saveAll(orderItems);
        */
        return order;
    }

    /**
     * Calculate subtotal.
     *
     * @param cart the cart
     * @return the double
     */
    private double calculateSubtotal(Cart cart) {
        return cart.getItems().values().stream()
                .mapToDouble(item -> item.getQuantity() * item.getBook().getPrice().doubleValue())
                .sum();
    }    
}

