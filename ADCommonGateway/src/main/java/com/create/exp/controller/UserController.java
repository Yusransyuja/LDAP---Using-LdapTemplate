package com.create.exp.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.create.exp.message.AdRequest;
import com.create.exp.message.AdResponse;
import com.create.exp.service.UserService;

@RestController
public class UserController {
	
	private static Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	private UserService userService; 
	
	@PostMapping(value = "/api/ad/getAllProfile")
	public ResponseEntity<AdResponse> getAllProfile(@RequestBody AdRequest request ) throws Exception {	
		AdResponse response = new AdResponse();
		
		try {	
			List dataList = userService.getAllProfile();
			
			logger.info(dataList.size());
			
			response.setDataList(dataList);
		}catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/api/ad/getProfileByName")
	public ResponseEntity<AdResponse> getProfileByName(@RequestBody AdRequest request) throws Exception {	
		AdResponse response = new AdResponse();
		
		try {	
			logger.info(request.getFirstName());

			if(request.getFirstName() == null) {
				throw new Exception("request cannot be empty");
			}
			
			List dataList = userService.getProfileByFirstName(request.getFirstName());
			
			logger.info(dataList.size());
			
			response.setDataList(dataList);
		}catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		return ResponseEntity.ok(response);
	}
}
