package com.siddique.e_comerse_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siddique.e_comerse_web.entity.OrderEntity;

public interface OrderRepo extends JpaRepository<OrderEntity, Integer> {

}
