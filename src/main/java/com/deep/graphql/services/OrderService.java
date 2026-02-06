package com.deep.graphql.services;

import org.springframework.stereotype.Service;

import com.deep.graphql.entities.Order;
import com.deep.graphql.helper.ExceptionHelper;
import com.deep.graphql.repositories.OrderRepo;

import java.util.List;

@Service
public class OrderService {

    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    // Create order

    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    // get all order

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    // get single

    public Order getOrder(int orderId) {
       Order order =  orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
       return order;
    }


    // delete order

    public boolean deleteOrder(int orderId) {
        Order order =  orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        orderRepo.delete(order);
        return true;
    }
}
