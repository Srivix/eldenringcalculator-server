package com.eldenringcalculator.buildstate;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eldenringcalculator.buildstate.model.BuildStateEntity;

public interface BuildStateRepository extends CrudRepository<BuildStateEntity, Long>{
	
	BuildStateEntity findByName(String name);
	
	List<BuildStateEntity> findAll();
	
}
