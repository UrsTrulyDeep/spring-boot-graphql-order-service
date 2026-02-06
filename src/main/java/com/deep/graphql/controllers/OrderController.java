package com.deep.graphql.controllers;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.deep.graphql.entities.Order;
import com.deep.graphql.entities.User;
import com.deep.graphql.services.OrderService;
import com.deep.graphql.services.UserService;

import java.util.List;

@Controller
public class OrderController {

    private UserService userService;

    private OrderService orderService;

    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    // create order
    @MutationMapping
    public Order createOrder(
            @Argument  String orderDetail,
            @Argument  String address,
            @Argument  int price,
            @Argument  int userId
    ) {
        User user = userService.getUser(userId);

        Order order= new Order();
        order.setOrderDetail(orderDetail);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(user);

        Order order1 = orderService.createOrder(order);
        return order1;
    }

    // get orders
    @QueryMapping
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    // get order
    @QueryMapping
    public Order getOrder(@Argument int orderId) {
        return orderService.getOrder(orderId);
    }

    @MutationMapping
    public boolean deleteOrder(int orderId) {
        return orderService.deleteOrder(orderId);
    }
}
