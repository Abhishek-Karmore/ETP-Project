package com.onlinefooddelivery.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onlinefooddelivery.bean.Order;
import com.onlinefooddelivery.bean.Product;

	public interface OrderRepository extends JpaRepository<Order, Integer> {
		
		@Query("""
			    SELECT o
			    FROM Order o
			    JOIN FETCH o.product
			    WHERE o.userId = :userId
			""")
			    List<Order> getOrderDetailsByUserId(@Param("userId") Integer userId );
	}