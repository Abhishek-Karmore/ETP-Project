package com.onlinefooddelivery.bd;

import java.util.List;
import org.apache.catalina.connector.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.onlinefooddelivery.bean.Order;
import com.onlinefooddelivery.bean.OrderRequest;
import com.onlinefooddelivery.dao.OrderRepository;
import com.onlinefooddelivery.utility.BaseRequest;
import com.onlinefooddelivery.utility.BaseResponse;



@Service
public class OrderBDImpl implements OrderBD {

    private static final Logger LOG = LogManager.getFormatterLogger();

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public BaseResponse getOrderbyUserId(BaseRequest<OrderRequest> baseRequest, String logID) {
    	
    	OrderRequest OrderRequest=baseRequest.getFormData();
        Integer userId =OrderRequest.getUserId();
    	
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setLogId(logID);

        try {
            //fetch Order from Database 
        	
            List<Order> OrderList = orderRepository.getOrderDetailsByUserId(userId);
            
            if (OrderList.isEmpty()) {
                baseResponse.setRespCode("SUCCESS");
                baseResponse.setMessage("No Orders found for this User");
                baseResponse.setData(OrderList);
                return baseResponse;
            }

            baseResponse.setRespCode("Success");
            baseResponse.setMessage("Order list fetched successfully");
            baseResponse.setData(OrderList);
         
        } catch (Exception e) {
            LOG.error(logID + " DB ERROR", e);

            baseResponse.setRespCode("FAILURE");
            baseResponse.setMessage("Failed to fetch Orders");
          
        }

        return baseResponse;
    }

	
	@Override
	public BaseResponse saveOrderDetails(BaseRequest<OrderRequest>baseRequest, String logID) {

		
		BaseResponse baseResponse=new BaseResponse();
		
		 baseResponse.setLogId(logID);

	        try {
	        	
	        	OrderRequest OrderRequest= baseRequest.getFormData();
	        	
	        	Order Order=new Order();
	        	
	        	  Order.setUserId(OrderRequest.getUserId());
		          Order.setProductId(OrderRequest.getProductId());
		          Order.setQuantity(OrderRequest.getQuantity());
		          Order.setTotalAmount(OrderRequest.getTotalAmount());
	            
	        	
	            //Save Order from Database 
		        Order savedOrder = orderRepository.save(Order);
	            baseResponse.setRespCode("Success");
	            baseResponse.setMessage("Order save successfully");
	            baseResponse.setData(savedOrder);
	         
	        } catch (Exception e) {
	            LOG.error(logID + " DB ERROR", e);

	            baseResponse.setRespCode("FAILURE");
	            baseResponse.setMessage("Failed to save Orders");
	          
	        }
		
		return baseResponse;
	}
	

}
