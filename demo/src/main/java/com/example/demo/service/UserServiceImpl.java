package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService{
	
	private final UserRepository usrRepo;
	

	private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserRepository usrRepo ) {
        this.userMapper = userMapper;
        this.usrRepo = usrRepo;
    }

	
	public void saveUser(User usr) {
		
		//User usr = new User(1L,"sujatha", "reddy", "suji.aero@gmail.com");
		usrRepo.save(usr);
	}

	@Override
	public void registerUser(CustomerDTO custDTO) {
		User usr = userMapper.toEntity(custDTO);
		usrRepo.save(usr);		
	}

}
