package com.eldenringcalculator.weapontype;

import java.util.List;

import com.eldenringcalculator.weapontype.model.WeaponTypeEntity;

public interface WeaponTypeService {
	
	WeaponTypeEntity get(Long id);
	
	List<WeaponTypeEntity> findAll();

}
