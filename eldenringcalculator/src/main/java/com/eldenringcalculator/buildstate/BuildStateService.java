package com.eldenringcalculator.buildstate;

import java.util.List;

import com.eldenringcalculator.buildstate.model.BuildStateEntity;

public interface BuildStateService {
	
	BuildStateEntity findByName(String state);
	
	List<BuildStateEntity> findAll();

}
