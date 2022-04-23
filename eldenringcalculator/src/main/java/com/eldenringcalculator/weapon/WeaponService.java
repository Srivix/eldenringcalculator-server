package com.eldenringcalculator.weapon;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.eldenringcalculator.weapon.model.WeaponDto;
import com.eldenringcalculator.weapon.model.WeaponEntity;

public interface WeaponService {
	
	List<WeaponEntity> findAll();
	
	WeaponEntity get(Long id);
	
	ResponseEntity<?> save(WeaponDto dto,Long id);
	
	ResponseEntity<?> uploadImage(MultipartFile file, Long id);
}
