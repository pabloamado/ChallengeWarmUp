package com.alkemy.challenge.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.security.dto.CredentialsDto;
import com.alkemy.challenge.security.mapper.UserMapper;
import com.alkemy.challenge.security.model.User;
import com.alkemy.challenge.security.repository.UserRepository;

import java.io.IOException;
import java.util.Collections;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override //carga un usuario segun el username pasado por parametro
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		//ir a la db para cargar el usuario
		com.alkemy.challenge.security.model.User user=userRepository.findByEmail(username);
		
		if(user!=null) {
			
			return new org.springframework.security.core.userdetails.User
					(user.getUsername(),user.getPassword(),Collections.emptyList());//coleccion es la lista de roles
		}
		
		throw new UsernameNotFoundException("usuario o contraseña no encontrada");
		
	}

	public void registerUser(CredentialsDto credentialsDto) throws IOException {
		
			User user=userMapper.toUser(credentialsDto);
			
			user=userRepository.save(user);
			
	}

}
