package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.entity.User;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface UserMapper {
	
	CustomerDTO toDto(User user);
	

	@Mapping(source = "custEmail", target = "email")
    @Mapping(source = "custFirstName", target = "firstName")
    @Mapping(source = "custLastName", target = "lastName")
	@Mapping(source = "custPWD", target = "pwd")
    User toEntity(CustomerDTO custDto);


}
