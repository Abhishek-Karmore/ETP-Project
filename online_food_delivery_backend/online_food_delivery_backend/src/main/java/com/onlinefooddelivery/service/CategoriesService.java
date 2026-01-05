package com.onlinefooddelivery.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.onlinefooddelivery.utility.BaseResponse;

public interface CategoriesService {
	
    BaseResponse getAllCategories(String inputJsonString, String logID);
}
