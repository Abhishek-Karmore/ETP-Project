package com.onlinefooddelivery.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.onlinefooddelivery.constant.MessageConstants;
import com.onlinefooddelivery.service.CategoriesService;
import com.onlinefooddelivery.utility.BaseResponse;
import com.onlinefooddelivery.utility.LogIdUtil;


@RestController
@CrossOrigin
public class CategoriesController {

    private static final Logger LOG = LogManager.getFormatterLogger();

    @Autowired
    private CategoriesService categoriesService;
   
    
    @RequestMapping(
            path = RestMappingProvider.GET_ALL_CATEGORIES,
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
        )
        public BaseResponse<?> getAllCategories( HttpServletRequest request,  @RequestBody String inputJsonString) {

        	long startTime = System.currentTimeMillis();

            String logID = LogIdUtil.generateLogId();

            BaseResponse baseResponse =
                    categoriesService.getAllCategories(inputJsonString, logID);

            LOG.info(new StringBuilder()
                    .append(logID)
                    .append(" EXEC_TIME ")
                    .append(System.currentTimeMillis() - startTime));

            LOG.info(new StringBuilder()
                    .append(logID)
                    .append(" RESPONSE ")
                    .append(baseResponse.getMessage()));

            return baseResponse;
        }
    
    
    
}

