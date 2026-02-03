package com.siddique.e_comerse_web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddique.e_comerse_web.entity.product;
import com.siddique.e_comerse_web.repository.Productrepository;

@Service
public class ProductService {
   @Autowired
	Productrepository Producrepo;
   
   public String addproduct(product pro) {
	   Producrepo.save(pro);
	   return "success";
   }
   
   public List<product> getallproducts(){
	   return Producrepo.findAll();
   }
   
   public product getbyId(int product_id) {
	   return Producrepo.findById(product_id).get();
   }

   public String delete(int product_id) {
	   if(Producrepo.existsById(product_id)) {
              Producrepo.deleteById(product_id);
	   return "product with ID " + product_id + " deleted successfully!";
	  }
	  else {
	        return "product with ID " + product_id + " not found!";

	  }
    }
   
}
