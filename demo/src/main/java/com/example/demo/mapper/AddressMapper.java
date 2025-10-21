package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.DTO.AddressDTO;
import com.example.demo.entity.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {
	
	AddressDTO toDto(Address addr);
		
	Address toEntity(AddressDTO addrDto);

}
