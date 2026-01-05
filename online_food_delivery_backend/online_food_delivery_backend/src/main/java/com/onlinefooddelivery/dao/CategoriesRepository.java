package com.onlinefooddelivery.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinefooddelivery.bean.Categories;
import com.onlinefooddelivery.bean.Product;

	public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
		
		
	}