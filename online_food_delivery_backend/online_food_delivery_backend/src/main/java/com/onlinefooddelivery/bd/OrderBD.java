package com.onlinefooddelivery.bd;

import java.util.List;

import com.onlinefooddelivery.bean.OrderRequest;
import com.onlinefooddelivery.bean.Product;
import com.onlinefooddelivery.bean.ProductRequest;
import com.onlinefooddelivery.utility.BaseRequest;
import com.onlinefooddelivery.utility.BaseResponse;

public interface OrderBD {
  
    public BaseResponse getOrderbyUserId(BaseRequest<OrderRequest>baseRequest, String logID);
    public BaseResponse saveOrderDetails(BaseRequest<OrderRequest> baseRequest, String logID);


}
