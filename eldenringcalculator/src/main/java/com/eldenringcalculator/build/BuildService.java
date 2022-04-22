package com.eldenringcalculator.build;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;

import com.eldenringcalculator.build.model.BuildDto;
import com.eldenringcalculator.build.model.BuildEntity;
import com.eldenringcalculator.build.model.BuildSearchDto;
import com.eldenringcalculator.build.model.BuildSearchOfUserDto;

public interface BuildService {
	
	List<BuildEntity> findAll();
	
	void save(Long id, BuildDto dto);
	
	Page<BuildEntity> findPage(BuildSearchDto dto);


	Page<BuildEntity> findPageOfUser(String username, BuildSearchOfUserDto dto);

}
