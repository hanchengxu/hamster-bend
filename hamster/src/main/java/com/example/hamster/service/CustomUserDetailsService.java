package com.example.hamster.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.hamster.entity.User;
import com.example.hamster.mapper.UserMapper;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//从db中查询用户是否存在
		User existingUser =  mapper.findByUserName(username);
		
		if(null == existingUser) {
			throw new UsernameNotFoundException("no this user!");
		}

		//返回 spring security需要的 User Class
		return new org.springframework.security.core.userdetails.User(existingUser.getUserName(),
				existingUser.getPassword(), new ArrayList<>());
	}
}
