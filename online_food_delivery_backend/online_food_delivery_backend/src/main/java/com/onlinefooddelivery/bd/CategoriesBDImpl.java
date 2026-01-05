package com.onlinefooddelivery.bd;

import java.util.List;
import org.apache.catalina.connector.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.onlinefooddelivery.bean.Categories;
import com.onlinefooddelivery.dao.CategoriesRepository;
import com.onlinefooddelivery.dao.CategoriesRepository;
import com.onlinefooddelivery.utility.BaseRequest;
import com.onlinefooddelivery.utility.BaseResponse;



@Service
public class CategoriesBDImpl implements CategoriesBD {

    private static final Logger LOG = LogManager.getFormatterLogger();

    @Autowired
    private CategoriesRepository categoriesRepository;

  

	@Override
	public BaseResponse getAllCategories(BaseRequest baseRequest, String logID) {
		
    	
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setLogId(logID);

        try {
            //fetchCategories from Database 
        	
            List<Categories>categoriesList =categoriesRepository.findAll();
            
            if (categoriesList.isEmpty()) {
                baseResponse.setRespCode("SUCCESS");
                baseResponse.setMessage("NoCategoriess found for this category");
                baseResponse.setData(categoriesList);
                return baseResponse;
            }

            baseResponse.setRespCode("Success");
            baseResponse.setMessage("Categories list fetched successfully");
            baseResponse.setData(categoriesList);
         
        } catch (Exception e) {
            LOG.error(logID + " DB ERROR", e);

            baseResponse.setRespCode("FAILURE");
            baseResponse.setMessage("Failed to fetchCategoriess");
          
        }

        return baseResponse;
	}
	
	


}
