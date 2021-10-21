package com.alkemy.challenge.security.mapper;

import org.springframework.stereotype.Component;

import com.alkemy.challenge.security.dto.CredentialsDto;
import com.alkemy.challenge.security.model.User;

@Component
public class UserMapper {

	public User toUser(CredentialsDto credentials) {
		
		User user=new User();
		user.setEmail(credentials.getEmail());
		user.setPassword(credentials.getPassword());
	
		return user;
	}
}
