package com.onlinefooddelivery.bd;

import java.util.List;

import com.onlinefooddelivery.bean.Product;
import com.onlinefooddelivery.bean.ProductRequest;
import com.onlinefooddelivery.utility.BaseRequest;
import com.onlinefooddelivery.utility.BaseResponse;

public interface CategoriesBD {
  
    public BaseResponse getAllCategories(BaseRequest baseRequest, String logID);

}
