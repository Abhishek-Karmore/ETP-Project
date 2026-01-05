package com.onlinefooddelivery.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinefooddelivery.bean.Product;

	public interface ProductRepository extends JpaRepository<Product, Integer> {
		
		 // 🔥 Fetch ALL products by categoryId
	    List<Product> findByCategoryId(Integer categoryId);
	}