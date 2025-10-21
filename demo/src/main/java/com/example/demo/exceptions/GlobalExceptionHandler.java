package com.example.demo.exceptions;

import java.net.http.HttpHeaders;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.DTO.ErrorsDTO;
import com.example.demo.DTO.ResponseDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleValidationErrors(MethodArgumentNotValidException ex) {
		ResponseDTO res = new ResponseDTO();
        List<ErrorsDTO> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(e -> {
                	ErrorsDTO eDTO = new ErrorsDTO();
                	eDTO.setErrorMsg(e.getDefaultMessage());
                	eDTO.setErrorDesc(e.getField());
                	//eDTO.setErrorId(Integer.parseInt(e.getCode()));
                	return eDTO;
                })
                .collect(Collectors.toList());
        res.setErrors(errors);
        return new ResponseEntity<>(res,  HttpStatus.BAD_REQUEST);
    }
	
	
	
	

}
