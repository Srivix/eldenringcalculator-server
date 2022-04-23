package com.eldenringcalculator.build;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;

import com.eldenringcalculator.build.model.BuildDto;
import com.eldenringcalculator.build.model.BuildSearchDto;

public interface BuildService {
	
	ResponseEntity<?> save(Long id, BuildDto dto, String username);
	
	HashMap<String, Object> findPage(BuildSearchDto dto);

	HashMap<String, Object> findPageOfUser(String username, BuildSearchDto dto);
	
	HashMap<String, Object> findPageOfAllBuilds(BuildSearchDto dto);
	
	ResponseEntity<?> delete(Long id, String username);

}
