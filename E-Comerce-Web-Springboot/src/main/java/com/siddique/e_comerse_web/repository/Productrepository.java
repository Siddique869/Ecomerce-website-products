package com.siddique.e_comerse_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siddique.e_comerse_web.entity.product;

@Repository
public interface Productrepository extends JpaRepository<product, Integer> {

}
