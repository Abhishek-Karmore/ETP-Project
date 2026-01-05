package com.onlinefooddelivery.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.onlinefooddelivery.utility.BaseResponse;

public interface ProductService {
	
    BaseResponse getProductsbyCatId(String inputJsonString, String logID);
    BaseResponse getAllProducts(String inputJsonString, String logID);
    BaseResponse saveProductDetails(String inputJsonString, String logID);
    BaseResponse updateProductDetails(String inputJsonString, String logID);
    BaseResponse deleteProductDetails(String inputJsonString, String logID);
}
