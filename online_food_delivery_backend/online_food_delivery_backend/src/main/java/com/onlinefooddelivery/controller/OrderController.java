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
import com.onlinefooddelivery.service.OrderService;
import com.onlinefooddelivery.utility.BaseResponse;
import com.onlinefooddelivery.utility.LogIdUtil;


@RestController
@CrossOrigin
public class OrderController {

    private static final Logger LOG = LogManager.getFormatterLogger();

    @Autowired
    private OrderService orderService;
    
   
    
    @RequestMapping(
            path = RestMappingProvider.GET_ORDER_DETAILS_USERID,
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
        )
        public BaseResponse<?> getOrderbyUserId( HttpServletRequest request,  @RequestBody String inputJsonString) {

        	long startTime = System.currentTimeMillis();

            String logID = LogIdUtil.generateLogId();

            BaseResponse baseResponse =
            		orderService.getOrderbyUserId(inputJsonString, logID);

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
    
    @RequestMapping(
            path = RestMappingProvider.SAVE_ORDER_DETAILS,
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
        )
        public BaseResponse<?> saveOrders( HttpServletRequest request,  @RequestBody String inputJsonString) {

        	long startTime = System.currentTimeMillis();

            String logID = LogIdUtil.generateLogId();

            BaseResponse baseResponse =
            		orderService.saveOrderDetails(inputJsonString, logID);

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

