package com.create.exp.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.create.exp.constants.ApplicationConstants;
import com.create.exp.message.AdRequest;
import com.create.exp.message.AdResponse;
import com.create.exp.service.UserService;

@RestController
public class UserController {
	
	private static Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	private UserService userService; 
	
	@PostMapping(value = "/api/ad/getAllProfile")
	public void getAllProfile() throws Exception {	
		try {	
			List dataList = userService.getAllProfile();
			
			logger.info(dataList.size());
		}catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
	
	@PostMapping(value = "/api/ad/getProfileByName")
	public void getProfileByName(@RequestBody AdRequest request) throws Exception {	
		
		try {	
			logger.info(request.getFirstName());

			if(request.getFirstName() == null) {
				throw new Exception(ApplicationConstants.EXCEPTION_INVALID_REQUEST);
			}
			
			List dataList = userService.getProfileByFirstName(request.getFirstName());
			
			logger.info(dataList.size());
		}catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
}
