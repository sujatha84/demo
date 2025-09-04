package com.example.demo.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	private Map<Integer,String> user = Map.of(1,"sujatha");
	
	@GetMapping("/greet")
	public ResponseEntity<String> greetUser() {
		return new ResponseEntity<>(user.get(1), HttpStatus.OK);
		
	}

}
