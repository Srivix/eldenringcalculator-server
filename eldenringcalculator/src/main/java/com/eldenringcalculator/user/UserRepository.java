package com.eldenringcalculator.user;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.eldenringcalculator.user.model.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{

	Optional<UserEntity> findByUsername(String username);

}
