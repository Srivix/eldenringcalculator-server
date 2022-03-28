package com.eldenringcalculator.buildstate;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.eldenringcalculator.buildstate.model.BuildStateEntity;

public interface BuildStateRepository extends CrudRepository<BuildStateEntity, Long>{
	
	Optional<BuildStateEntity> findByName(String name);
}
