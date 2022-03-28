package com.eldenringcalculator.user;

import com.eldenringcalculator.user.model.UserEntity;

public interface UserService {

	UserEntity get(String username);

}
