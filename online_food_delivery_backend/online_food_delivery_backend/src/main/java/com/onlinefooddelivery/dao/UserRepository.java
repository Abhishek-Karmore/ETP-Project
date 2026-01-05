package com.onlinefooddelivery.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.onlinefooddelivery.bean.Product;


import com.onlinefooddelivery.bean.User;

	public interface UserRepository extends JpaRepository<User, Integer> {
		
	}