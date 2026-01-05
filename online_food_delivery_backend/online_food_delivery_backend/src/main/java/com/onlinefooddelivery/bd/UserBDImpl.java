package com.onlinefooddelivery.bd;

import java.util.List;
import org.apache.catalina.connector.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.onlinefooddelivery.bean.User;
import com.onlinefooddelivery.bean.UserRequest;
import com.onlinefooddelivery.dao.UserRepository;
import com.onlinefooddelivery.utility.BaseRequest;
import com.onlinefooddelivery.utility.BaseResponse;



@Service
public class UserBDImpl implements UserBD {

    private static final Logger LOG = LogManager.getFormatterLogger();

    @Autowired
    private UserRepository userRepository;

    @Override
    public BaseResponse getUserDetails(BaseRequest<UserRequest> baseRequest, String logID) {
    	
    	UserRequest userRequest=baseRequest.getFormData();
    	
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setLogId(logID);

        try {
            //fetch User from Database 
        	
            List<User> userList = userRepository.findAll();
            
            if (userList.isEmpty()) {
                baseResponse.setRespCode("SUCCESS");
                baseResponse.setMessage("No users found for this category");
                baseResponse.setData(userList);
                return baseResponse;
            }

            baseResponse.setRespCode("Success");
            baseResponse.setMessage("User list fetched successfully");
            baseResponse.setData(userList);
         
        } catch (Exception e) {
            LOG.error(logID + " DB ERROR", e);

            baseResponse.setRespCode("FAILURE");
            baseResponse.setMessage("Failed to fetch users");
          
        }

        return baseResponse;
    }

	@Override
	public BaseResponse saveUserDetails(BaseRequest<UserRequest>baseRequest, String logID) {

		
		BaseResponse baseResponse=new BaseResponse();
		
		 baseResponse.setLogId(logID);

	        try {
	        	
	        	UserRequest userRequest= baseRequest.getFormData();
	        	
	        	User user=new User();
	        	
	        	  user.setUserName(userRequest.getUserName());
		          user.setEmail(userRequest.getEmail());
		          user.setPassword(userRequest.getPassword());
		          user.setRole("User");
	            
	        	
	            //Save User from Database 
		        User savedUser = userRepository.save(user);
	            baseResponse.setRespCode("Success");
	            baseResponse.setMessage("User save successfully");
	            baseResponse.setData(savedUser);
	         
	        } catch (Exception e) {
	            LOG.error(logID + " DB ERROR", e);

	            baseResponse.setRespCode("FAILURE");
	            baseResponse.setMessage("Failed to save users");
	          
	        }
		
		return baseResponse;
	}
}
