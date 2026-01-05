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
import com.onlinefooddelivery.service.ProductService;
import com.onlinefooddelivery.utility.BaseResponse;
import com.onlinefooddelivery.utility.LogIdUtil;


@RestController
@CrossOrigin
public class ProductController {

    private static final Logger LOG = LogManager.getFormatterLogger();

    @Autowired
    private ProductService productService;
    
    @RequestMapping(RestMappingProvider.INFO)
    public ResponseEntity<String> info() {
        return new ResponseEntity<>("PRODUCT SERVICE UP", HttpStatus.OK);
    }


    @RequestMapping(
        path = RestMappingProvider.GET_PRODUCT_DETAILS_CATID,
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public BaseResponse<?> getallproductsbyCatId( HttpServletRequest request,  @RequestBody String inputJsonString) {

    	long startTime = System.currentTimeMillis();

        String logID = LogIdUtil.generateLogId();

        BaseResponse baseResponse =
                productService.getProductsbyCatId(inputJsonString, logID);

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
            path = RestMappingProvider.GET_ALL_PRODUCTS,
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
        )
        public BaseResponse<?> getallproducts( HttpServletRequest request,  @RequestBody String inputJsonString) {

        	long startTime = System.currentTimeMillis();

            String logID = LogIdUtil.generateLogId();

            BaseResponse baseResponse =
                    productService.getAllProducts(inputJsonString, logID);

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
            path = RestMappingProvider.SAVE_PRODUCT_DETAILS,
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
        )
        public BaseResponse<?> saveproducts( HttpServletRequest request,  @RequestBody String inputJsonString) {

        	long startTime = System.currentTimeMillis();

            String logID = LogIdUtil.generateLogId();

            BaseResponse baseResponse =
                    productService.saveProductDetails(inputJsonString, logID);

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
            path = RestMappingProvider.UPDATE_PRODUCT_DETAILS,
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
        )
        public BaseResponse<?> updateproducts( HttpServletRequest request,  @RequestBody String inputJsonString) {

        	long startTime = System.currentTimeMillis();

            String logID = LogIdUtil.generateLogId();

            BaseResponse baseResponse =
                    productService.updateProductDetails(inputJsonString, logID);

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
            path = RestMappingProvider.DELETE_PRODUCT_DETAILS,
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
        )
        public BaseResponse<?> deleteproducts( HttpServletRequest request,  @RequestBody String inputJsonString) {

        	long startTime = System.currentTimeMillis();

            String logID = LogIdUtil.generateLogId();

            BaseResponse baseResponse =
                    productService.deleteProductDetails(inputJsonString, logID);

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

