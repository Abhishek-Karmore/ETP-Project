package com.onlinefooddelivery.service;

import java.lang.reflect.Type;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.onlinefooddelivery.bd.CategoriesBD;
import com.onlinefooddelivery.constant.ActionConstants;
import com.onlinefooddelivery.utility.BaseRequest;
import com.onlinefooddelivery.utility.BaseResponse;
import com.onlinefooddelivery.utility.JsonStringToObjectConverter;



@Service
public class CategoriesServiceImpl implements CategoriesService {

    private static final Logger LOG = LogManager.getFormatterLogger();

    @Autowired
    private CategoriesBD categoriesBD;

 // 🔥 PRESERVE GENERIC TYPE
    Type type = new TypeReference<BaseRequest>() {}.getType();

 
    
    @Override
    public BaseResponse getAllCategories (String inputJsonString, String logID) {

        BaseResponse baseResponse = new BaseResponse();

        BaseRequest baseRequest =
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

        if (ActionConstants.ACTION_ID_GET_ALL_CATEGORIES
                .equalsIgnoreCase(actionId)) {

            baseResponse = categoriesBD.getAllCategories(baseRequest, logID);

        } else {
            LOG.error(logID + " INVALID ACTION ID");
            baseResponse.setMessage("Invalid Action Id");
        }

        return baseResponse;
    }

	
}