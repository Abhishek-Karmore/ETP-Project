package com.onlinefooddelivery.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.onlinefooddelivery.utility.BaseResponse;

public interface OrderService {
	
    BaseResponse getOrderbyUserId(String inputJsonString, String logID);
    BaseResponse saveOrderDetails(String inputJsonString, String logID);

}
