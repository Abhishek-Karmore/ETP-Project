package com.onlinefooddelivery.service;

import java.lang.reflect.Type;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.onlinefooddelivery.bd.ProductBD;
import com.onlinefooddelivery.bean.ProductRequest;
import com.onlinefooddelivery.constant.ActionConstants;
import com.onlinefooddelivery.utility.BaseRequest;
import com.onlinefooddelivery.utility.BaseResponse;
import com.onlinefooddelivery.utility.JsonStringToObjectConverter;



@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LogManager.getFormatterLogger();

    @Autowired
    private ProductBD productBD;

 // 🔥 PRESERVE GENERIC TYPE
    Type type = new TypeReference<BaseRequest<ProductRequest>>() {}.getType();

    
    @Override
    public BaseResponse getProductsbyCatId(String inputJsonString, String logID) {

        BaseResponse baseResponse = new BaseResponse();

        BaseRequest<ProductRequest> baseRequest =
                JsonStringToObjectConverter.convert(
		        inputJsonString,
		        logID,
		        type
		);

        if (baseRequest == null) {
            LOG.error(logID + " INPUT JSON CONVERSION FAILED");
            baseResponse.setMessage("Input JSON conversion failed");
            return baseResponse;
        }

        //  actionId access
        String actionId = baseRequest.getActionId();

        if (ActionConstants.ACTION_ID_GET_PRODUCTS_BY_CATID
                .equalsIgnoreCase(actionId)) {

            baseResponse = productBD.getProductsbyCatId(baseRequest, logID);

        } else {
            LOG.error(logID + " INVALID ACTION ID");
            baseResponse.setMessage("Invalid Action Id");
        }

        return baseResponse;
    }

    
    @Override
    public BaseResponse getAllProducts (String inputJsonString, String logID) {

        BaseResponse baseResponse = new BaseResponse();

        BaseRequest<ProductRequest> baseRequest =
                JsonStringToObjectConverter.convert(
		        inputJsonString,
		        logID,
		        type
		);

        if (baseRequest == null) {
            LOG.error(logID + " INPUT JSON CONVERSION FAILED");
            baseResponse.setMessage("Input JSON conversion failed");
            return baseResponse;
        }

        //  actionId access
        String actionId = baseRequest.getActionId();

        if (ActionConstants.ACTION_ID_GET_ALL_PRODUCTS
                .equalsIgnoreCase(actionId)) {

            baseResponse = productBD.getAllProducts(baseRequest, logID);

        } else {
            LOG.error(logID + " INVALID ACTION ID");
            baseResponse.setMessage("Invalid Action Id");
        }

        return baseResponse;
    }

	@Override
	public BaseResponse saveProductDetails(String inputJsonString, String logID) {
		
        BaseResponse baseResponse = new BaseResponse();
        
        BaseRequest<ProductRequest> baseRequest =
                (BaseRequest<ProductRequest>) JsonStringToObjectConverter.convert(
		        inputJsonString,
		        logID,
		        type
		);
        
        if (baseRequest == null) {
            LOG.error(logID + " INPUT JSON CONVERSION FAILED");
            baseResponse.setMessage("Input JSON conversion failed");
            return baseResponse;
        }

        //  actionId access
        String actionId = baseRequest.getActionId();

        if (ActionConstants.ACTION_ID_SAVE_ALL_PRODUCTS
                .equalsIgnoreCase(actionId)) {

            baseResponse = productBD.saveAllProducts(baseRequest, logID);

        } else {
            LOG.error(logID + " INVALID ACTION ID");
            baseResponse.setMessage("Invalid Action Id");
        }
        
		return baseResponse;
	}
	
	
	@Override
	public BaseResponse updateProductDetails(String inputJsonString, String logID) {
		
        BaseResponse baseResponse = new BaseResponse();
        
        BaseRequest<ProductRequest> baseRequest =
                (BaseRequest<ProductRequest>) JsonStringToObjectConverter.convert(
		        inputJsonString,
		        logID,
		        type
		);
        
        if (baseRequest == null) {
            LOG.error(logID + " INPUT JSON CONVERSION FAILED");
            baseResponse.setMessage("Input JSON conversion failed");
            return baseResponse;
        }

        //  actionId access
        String actionId = baseRequest.getActionId();

        if (ActionConstants.ACTION_ID_UPDATE_PRODUCTS
                .equalsIgnoreCase(actionId)) {

            baseResponse = productBD.updateProductDetails(baseRequest, logID);

        } else {
            LOG.error(logID + " INVALID ACTION ID");
            baseResponse.setMessage("Invalid Action Id");
        }
        
		return baseResponse;
	}
	
	
	@Override
	public BaseResponse deleteProductDetails(String inputJsonString, String logID) {
		
        BaseResponse baseResponse = new BaseResponse();
        
        BaseRequest<ProductRequest> baseRequest =
                (BaseRequest<ProductRequest>) JsonStringToObjectConverter.convert(
		        inputJsonString,
		        logID,
		        type
		);
        
        if (baseRequest == null) {
            LOG.error(logID + " INPUT JSON CONVERSION FAILED");
            baseResponse.setMessage("Input JSON conversion failed");
            return baseResponse;
        }

        //  actionId access
        String actionId = baseRequest.getActionId();

        if (ActionConstants.ACTION_ID_DELETE_PRODUCTS
                .equalsIgnoreCase(actionId)) {

            baseResponse = productBD.deleteProductDetails(baseRequest, logID);

        } else {
            LOG.error(logID + " INVALID ACTION ID");
            baseResponse.setMessage("Invalid Action Id");
        }
        
		return baseResponse;
	}
}