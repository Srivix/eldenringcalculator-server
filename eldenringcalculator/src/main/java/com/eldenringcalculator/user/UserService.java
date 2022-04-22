package com.eldenringcalculator.user;

import com.eldenringcalculator.user.model.UserEntity;

public interface UserService {

	UserEntity findByUsername(String username);

}
