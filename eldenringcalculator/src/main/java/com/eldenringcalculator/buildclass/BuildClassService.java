package com.eldenringcalculator.buildclass;

import java.util.List;

import com.eldenringcalculator.buildclass.model.BuildClassEntity;

public interface BuildClassService {
	
	List<BuildClassEntity> findAll();
	
	BuildClassEntity findById(Long id);

}
