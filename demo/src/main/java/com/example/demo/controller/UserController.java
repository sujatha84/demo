package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.DTO.ResponseDTO;
import com.example.demo.service.IUserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	private IUserService IUsrSrvc;
	
	private Map<Integer,String> user = Map.of(1,"sujatha");
	
	@GetMapping("/greet")
	public ResponseEntity<String> greetUser() {
		return new ResponseEntity<>(user.get(1), HttpStatus.OK);		 
	}
	
	@GetMapping("/users")
	public ResponseEntity<ResponseDTO> getAllUsers(){
		ResponseDTO res = new ResponseDTO();
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<String> getUserById( @PathVariable int id){
		return new ResponseEntity<>(user.get(1), HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> registerUser(@Valid @RequestBody CustomerDTO customer ){
		
		IUsrSrvc.registerUser(customer);
		ResponseDTO res = new ResponseDTO();
		
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
