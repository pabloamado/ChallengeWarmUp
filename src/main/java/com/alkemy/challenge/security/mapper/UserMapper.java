package com.alkemy.challenge.security.mapper;

import org.springframework.stereotype.Component;

import com.alkemy.challenge.security.dto.UserDto;
import com.alkemy.challenge.security.model.User;

@Component
public class UserMapper {

	public User toUser(UserDto credentials) {
		
		User user=new User();
		
		if(credentials!=null) {
			
			user.setEmail(credentials.getEmail());
			user.setPassword(credentials.getPassword());
			
		}
	
		return user;
	}
}
