package com.eldenringcalculator.user;

import java.util.List;

import com.eldenringcalculator.user.model.UserEntity;

public interface UserService {
	
	List<UserEntity> findAll();

}
