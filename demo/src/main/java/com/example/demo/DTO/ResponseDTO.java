package com.example.demo.DTO;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class ResponseDTO {
	
	private List<CustomerDTO> Users;
	
	private List<ErrorsDTO> errors;

}
