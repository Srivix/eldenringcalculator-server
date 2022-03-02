package com.eldenringcalculator.build;

import java.util.List;

import com.eldenringcalculator.build.model.BuildDto;
import com.eldenringcalculator.build.model.BuildEntity;

public interface BuildService {
	
	List<BuildEntity> findAll();
	
	void save(Long id, BuildDto dto);

}
