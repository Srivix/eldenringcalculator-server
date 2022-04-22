package com.eldenringcalculator.build;

import org.springframework.data.domain.Page;

import com.eldenringcalculator.build.model.BuildDto;
import com.eldenringcalculator.build.model.BuildEntity;
import com.eldenringcalculator.build.model.BuildSearchDto;

public interface BuildService {
	
	void save(Long id, BuildDto dto, String author);
	
	Page<BuildEntity> findPage(BuildSearchDto dto);

	Page<BuildEntity> findPageOfUser(String username, BuildSearchDto dto);
	
	Page<BuildEntity> findPageOfAllBuilds(BuildSearchDto dto);

}
