package com.alkemy.challenge.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.Exception.UserException;
import com.alkemy.challenge.Exception.msg.ErrorMsg;
import com.alkemy.challenge.security.dto.UserDto;
import com.alkemy.challenge.security.mapper.UserMapper;
import com.alkemy.challenge.security.model.User;
import com.alkemy.challenge.security.repository.UserRepository;
import java.io.IOException;
import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Override 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		com.alkemy.challenge.security.model.User user = userRepository.findByEmail(username);

		if (user != null) {

			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					Collections.emptyList());
		}

		throw new UsernameNotFoundException(ErrorMsg.userNotFoundMsg());

	}

	public void registerUser(UserDto credentialsDto) throws IOException {

		User user = userMapper.toUser(credentialsDto);

		User userRecovered = userRepository.findByEmail(user.getUsername());

		if (userRecovered != null) {

			throw new UserException(ErrorMsg.UserExistsMsg());
		}

		user = userRepository.save(user);

	}

	public User findUserByEmail(String username) {

		return userRepository.findByEmail(username);
	}

}
