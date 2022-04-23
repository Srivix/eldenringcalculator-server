package com.eldenringcalculator.user;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import com.eldenringcalculator.user.model.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{

	@EntityGraph(attributePaths = {"roles"})
	UserEntity findByUsername(String username);

	@EntityGraph(attributePaths = {"roles"})
	UserEntity findByEmail(String email);

}
