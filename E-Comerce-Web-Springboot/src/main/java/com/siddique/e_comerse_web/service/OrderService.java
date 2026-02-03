package com.siddique.e_comerse_web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddique.e_comerse_web.entity.OrderEntity;
import com.siddique.e_comerse_web.repository.OrderRepo;

@Service
public class OrderService {

	   @Autowired
    OrderRepo  orderRepo;

    public String saveOrder(OrderEntity order) {
        orderRepo.save(order);
        return "Order placed successfully!";
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepo.findAll();
    }
}
