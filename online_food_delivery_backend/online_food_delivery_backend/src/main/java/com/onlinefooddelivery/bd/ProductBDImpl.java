package com.onlinefooddelivery.bd;

import java.util.List;
import org.apache.catalina.connector.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.onlinefooddelivery.bean.Product;
import com.onlinefooddelivery.bean.ProductRequest;
import com.onlinefooddelivery.dao.ProductRepository;
import com.onlinefooddelivery.utility.BaseRequest;
import com.onlinefooddelivery.utility.BaseResponse;



@Service
public class ProductBDImpl implements ProductBD {

    private static final Logger LOG = LogManager.getFormatterLogger();

    @Autowired
    private ProductRepository productRepository;

    @Override
    public BaseResponse getProductsbyCatId(BaseRequest<ProductRequest> baseRequest, String logID) {
    	
    	ProductRequest productRequest=baseRequest.getFormData();
        Integer categoryId =productRequest.getCategoryId();
    	
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setLogId(logID);

        try {
            //fetch Product from Database 
        	
            List<Product> productList = productRepository.findByCategoryId(categoryId);
            
            if (productList.isEmpty()) {
                baseResponse.setRespCode("SUCCESS");
                baseResponse.setMessage("No products found for this category");
                baseResponse.setData(productList);
                return baseResponse;
            }

            baseResponse.setRespCode("Success");
            baseResponse.setMessage("Product list fetched successfully");
            baseResponse.setData(productList);
         
        } catch (Exception e) {
            LOG.error(logID + " DB ERROR", e);

            baseResponse.setRespCode("FAILURE");
            baseResponse.setMessage("Failed to fetch products");
          
        }

        return baseResponse;
    }

	@Override
	public BaseResponse getAllProducts(BaseRequest<ProductRequest> baseRequest, String logID) {
		ProductRequest productRequest=baseRequest.getFormData();
        Integer categoryId =productRequest.getCategoryId();
    	
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setLogId(logID);

        try {
            //fetch Product from Database 
        	
            List<Product> productList = productRepository.findAll();
            
            if (productList.isEmpty()) {
                baseResponse.setRespCode("SUCCESS");
                baseResponse.setMessage("No products found for this category");
                baseResponse.setData(productList);
                return baseResponse;
            }

            baseResponse.setRespCode("Success");
            baseResponse.setMessage("Product list fetched successfully");
            baseResponse.setData(productList);
         
        } catch (Exception e) {
            LOG.error(logID + " DB ERROR", e);

            baseResponse.setRespCode("FAILURE");
            baseResponse.setMessage("Failed to fetch products");
          
        }

        return baseResponse;
	}
	
	@Override
	public BaseResponse saveAllProducts(BaseRequest<ProductRequest>baseRequest, String logID) {

		
		BaseResponse baseResponse=new BaseResponse();
		
		 baseResponse.setLogId(logID);

	        try {
	        	
	        	ProductRequest productRequest= baseRequest.getFormData();
	        	
	        	Product product=new Product();
	        	
	        	  product.setCategoryId(productRequest.getCategoryId());
		          product.setProductName(productRequest.getProductName());
		          product.setPrice(productRequest.getPrice());
		          product.setImageUrl(productRequest.getImageUrl());
	            
	        	
	            //Save Product from Database 
		        Product savedProduct = productRepository.save(product);
	            baseResponse.setRespCode("Success");
	            baseResponse.setMessage("Product save successfully");
	            baseResponse.setData(savedProduct);
	         
	        } catch (Exception e) {
	            LOG.error(logID + " DB ERROR", e);

	            baseResponse.setRespCode("FAILURE");
	            baseResponse.setMessage("Failed to save products");
	          
	        }
		
		return baseResponse;
	}
	
	@Override
	public BaseResponse updateProductDetails(BaseRequest<ProductRequest> baseRequest, String logID) {

	    BaseResponse baseResponse = new BaseResponse();
	    baseResponse.setLogId(logID);

	    try {
	        ProductRequest productRequest = baseRequest.getFormData();
	        Integer productId = productRequest.getProductId();

	        //  Validation: productId null
	        if (productId == null) {
	            baseResponse.setRespCode("FAILURE");
	            baseResponse.setMessage("Product ID is required");
	            return baseResponse;
	        }

	        //  Validation: product exists or not
	        if (!productRepository.existsById(productId)) {
	            baseResponse.setRespCode("FAILURE");
	            baseResponse.setMessage("Product not found for given productId");
	            return baseResponse;
	        }

	        //  Fetch product (safe now)
	        Product product = productRepository.findById(productId).get();

	        //  Update fields
	        product.setProductName(productRequest.getProductName());
	        product.setCategoryId(productRequest.getCategoryId());
	        product.setPrice(productRequest.getPrice());
	        product.setImageUrl(productRequest.getImageUrl());

	        //  Save (UPDATE)
	        Product updatedProduct = productRepository.save(product);

	        baseResponse.setRespCode("SUCCESS");
	        baseResponse.setMessage("Product updated successfully");
	        baseResponse.setData(updatedProduct);

	    } catch (Exception e) {
	        LOG.error(logID + " UPDATE PRODUCT ERROR", e);

	        baseResponse.setRespCode("FAILURE");
	        baseResponse.setMessage("Failed to update product");
	    }

	    return baseResponse;
	}


	@Override
	public BaseResponse deleteProductDetails(BaseRequest<ProductRequest> baseRequest, String logID) {

	    BaseResponse baseResponse = new BaseResponse();
	    baseResponse.setLogId(logID);

	    try {
	        ProductRequest productRequest = baseRequest.getFormData();
	        Integer productId = productRequest.getProductId();

	        //  Check existence
	        if (!productRepository.existsById(productId)) {
	            baseResponse.setRespCode("SUCCESS");
	            baseResponse.setMessage("Product already deleted or not found");
	            return baseResponse;
	        }

	        //  Delete
	        productRepository.deleteById(productId);

	        baseResponse.setRespCode("SUCCESS");
	        baseResponse.setMessage("Product deleted successfully");

	    } catch (Exception e) {
	        LOG.error(logID + " DELETE PRODUCT ERROR", e);

	        baseResponse.setRespCode("FAILURE");
	        baseResponse.setMessage("Failed to delete product");
	    }

	    return baseResponse;
	}


}
