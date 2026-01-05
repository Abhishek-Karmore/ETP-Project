package com.onlinefooddelivery.bd;

import java.util.List;

import com.onlinefooddelivery.bean.Product;
import com.onlinefooddelivery.bean.UserRequest;
import com.onlinefooddelivery.utility.BaseRequest;
import com.onlinefooddelivery.utility.BaseResponse;

public interface UserBD {
  
    public BaseResponse getUserDetails(BaseRequest<UserRequest>baseRequest, String logID);
    public BaseResponse saveUserDetails(BaseRequest<UserRequest> baseRequest, String logID);

}
