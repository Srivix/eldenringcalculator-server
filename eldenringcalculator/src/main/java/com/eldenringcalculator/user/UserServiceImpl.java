package com.eldenringcalculator.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eldenringcalculator.user.model.UserEntity;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserEntity get(String username) {
		return this.userRepository.findByUsername(username).orElse(null);
	}

}
