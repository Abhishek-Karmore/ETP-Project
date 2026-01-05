package com.onlinefooddelivery.service;

import java.lang.reflect.Type;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.onlinefooddelivery.bd.OrderBD;
import com.onlinefooddelivery.bean.OrderRequest;
import com.onlinefooddelivery.constant.ActionConstants;
import com.onlinefooddelivery.utility.BaseRequest;
import com.onlinefooddelivery.utility.BaseResponse;
import com.onlinefooddelivery.utility.JsonStringToObjectConverter;



@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOG = LogManager.getFormatterLogger();

    @Autowired
    private OrderBD orderBD;

 // 🔥 PRESERVE GENERIC TYPE
    Type type = new TypeReference<BaseRequest<OrderRequest>>() {}.getType();

    
    @Override
    public BaseResponse getOrderbyUserId(String inputJsonString, String logID) {

        BaseResponse baseResponse = new BaseResponse();

        BaseRequest<OrderRequest> baseRequest =
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

        if (ActionConstants.ACTION_ID_GET_ORDER_BY_USERID
                .equalsIgnoreCase(actionId)) {

            baseResponse = orderBD.getOrderbyUserId(baseRequest, logID);

        } else {
            LOG.error(logID + " INVALID ACTION ID");
            baseResponse.setMessage("Invalid Action Id");
        }

        return baseResponse;
    }

    
 
	@Override
	public BaseResponse saveOrderDetails(String inputJsonString, String logID) {
		
        BaseResponse baseResponse = new BaseResponse();
        
        BaseRequest<OrderRequest> baseRequest =
                (BaseRequest<OrderRequest>) JsonStringToObjectConverter.convert(
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

        if (ActionConstants.ACTION_ID_SAVE_ORDER
                .equalsIgnoreCase(actionId)) {

            baseResponse = orderBD.saveOrderDetails(baseRequest, logID);

        } else {
            LOG.error(logID + " INVALID ACTION ID");
            baseResponse.setMessage("Invalid Action Id");
        }
        
		return baseResponse;
	}
	
	
	
}