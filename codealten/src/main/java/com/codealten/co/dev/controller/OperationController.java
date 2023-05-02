package com.codealten.co.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codealten.co.dev.dto.RequestOperation;
import com.codealten.co.dev.dto.ResponseOperation;
import com.codealten.co.dev.impl.ServiceOperation;
import com.google.gson.Gson;

@RestController
@RequestMapping("test/code")
public class OperationController {
	
	@Autowired
	ServiceOperation serviceOperation;
	
	@GetMapping("/get/response")
	public ResponseEntity<String> getMaximunGet(
			@RequestParam(name = "x", defaultValue = "0") int x,
			@RequestParam(name = "y", defaultValue = "0") int y,
			@RequestParam(name = "n", defaultValue = "0") int n){
		
		ResponseOperation responseOperation = serviceOperation.operation(x, y, n);
		
		Gson gson = new Gson();
		String stringResponse = gson.toJson(responseOperation);
		
		return ResponseEntity.ok(stringResponse);
	}
	
	@PostMapping
	public ResponseEntity<String> getMaximunPost(@RequestBody String requestNumbers) {
		
		ResponseOperation responseOperation = new ResponseOperation();
		RequestOperation requestOperation = null;
		
		Gson gson = new Gson();
		
		try {
			requestOperation = gson.fromJson(requestNumbers, RequestOperation.class);
			responseOperation = serviceOperation.operation(
					requestOperation.getX(), 
					requestOperation.getY(), 
					requestOperation.getN());
			String stringResponse = gson.toJson(responseOperation);
			return new ResponseEntity<>(stringResponse, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
}