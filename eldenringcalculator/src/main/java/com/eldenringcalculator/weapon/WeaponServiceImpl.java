package com.eldenringcalculator.weapon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eldenringcalculator.weapon.model.WeaponEntity;

@Service
public class WeaponServiceImpl implements WeaponService{
	
	@Autowired
	WeaponRepository weaponRepository;
	
	@Override
	public List<WeaponEntity> findAll() {

		return this.weaponRepository.findAll();
	}

	@Override
	public WeaponEntity get(Long id) {

		return this.weaponRepository.findById(id).orElse(null);
	}

}
