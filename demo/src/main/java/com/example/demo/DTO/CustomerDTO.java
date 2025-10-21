package com.example.demo.DTO;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDTO {	
	
	@NotNull(message = "Invalid First Name: First Name is NULL")	
	private String custFirstName;
	
	@NotNull(message = "Invalid Last Name: Last Name is NULL")
	private String custLastName;
		
	@NotNull(message = "Invalid Email: Email is NULL")
	@Email(message = "Invalid Email: Invalid Email FormatL")
	private String custEmail;
	
	@NotNull(message = "Invalid PWD: PWD cannot be NULL")
	private String custPWD;
	
	
	private List<AddressDTO> addresses;

}
