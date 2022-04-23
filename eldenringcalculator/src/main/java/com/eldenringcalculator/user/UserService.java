package com.eldenringcalculator.user;

import org.springframework.http.ResponseEntity;

import com.eldenringcalculator.user.model.UserEntity;
import com.eldenringcalculator.user.model.UserSaveDto;

public interface UserService {

	UserEntity findByUsername(String username);
	
	ResponseEntity<?> save(UserSaveDto dto);

}
