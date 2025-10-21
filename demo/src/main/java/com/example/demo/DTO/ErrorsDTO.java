package com.example.demo.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorsDTO {
	
	
	private int errorId;
	
	private String errorMsg;
	
	private String errorDesc;

}
