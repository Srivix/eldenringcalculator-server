package com.eldenringcalculator.buildclass;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eldenringcalculator.buildclass.model.BuildClassEntity;

public interface BuildClassRepository extends CrudRepository<BuildClassEntity, Long>{
	
	List<BuildClassEntity> findAll();

}
