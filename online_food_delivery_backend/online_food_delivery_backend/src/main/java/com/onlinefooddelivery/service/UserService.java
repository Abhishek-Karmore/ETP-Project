package com.onlinefooddelivery.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.onlinefooddelivery.utility.BaseResponse;

public interface UserService {
	
    BaseResponse getUserDetails(String inputJsonString, String logID);
    BaseResponse saveUserDetails(String inputJsonString, String logID);
}
