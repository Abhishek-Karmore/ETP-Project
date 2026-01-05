package com.onlinefooddelivery.bd;

import java.util.List;

import com.onlinefooddelivery.bean.Product;
import com.onlinefooddelivery.bean.ProductRequest;
import com.onlinefooddelivery.utility.BaseRequest;
import com.onlinefooddelivery.utility.BaseResponse;

public interface ProductBD {
  
    public BaseResponse getProductsbyCatId(BaseRequest<ProductRequest>baseRequest, String logID);
    public BaseResponse getAllProducts(BaseRequest<ProductRequest>baseRequest, String logID);
    public BaseResponse saveAllProducts(BaseRequest<ProductRequest> baseRequest, String logID);
    public BaseResponse updateProductDetails(BaseRequest<ProductRequest> baseRequest, String logID);
    public BaseResponse deleteProductDetails(BaseRequest<ProductRequest> baseRequest, String logID);


}
