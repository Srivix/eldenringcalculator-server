package com.eldenringcalculator.weapontype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eldenringcalculator.weapontype.model.WeaponTypeEntity;

@Service
public class WeaponTypeServiceImpl implements WeaponTypeService{

	@Autowired
	WeaponTypeRepository weapontypeRepository;
	
	@Override
	public WeaponTypeEntity get(Long id) {

		return this.weapontypeRepository.findById(id).orElse(null);
	}

	@Override
	public List<WeaponTypeEntity> findAll() {

		return (List<WeaponTypeEntity>) this.weapontypeRepository.findAll();
	}

}
