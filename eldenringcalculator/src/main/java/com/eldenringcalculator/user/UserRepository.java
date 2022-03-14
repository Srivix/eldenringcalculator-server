package com.eldenringcalculator.user;

import org.springframework.data.repository.CrudRepository;

import com.eldenringcalculator.user.model.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{

}
