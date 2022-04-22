package com.eldenringcalculator.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.eldenringcalculator.user.model.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{

	UserEntity findByUsername(String username);
	
	@Query("select u from UserEntity u where u.username=?1")
	public UserEntity findByUsername2(String username);

}
