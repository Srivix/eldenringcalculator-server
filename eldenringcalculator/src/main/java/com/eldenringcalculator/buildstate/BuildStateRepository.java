package com.eldenringcalculator.buildstate;

import org.springframework.data.repository.CrudRepository;

import com.eldenringcalculator.buildstate.model.BuildStateEntity;

public interface BuildStateRepository extends CrudRepository<BuildStateEntity, Long>{
	
	BuildStateEntity findByName(String name);
}
