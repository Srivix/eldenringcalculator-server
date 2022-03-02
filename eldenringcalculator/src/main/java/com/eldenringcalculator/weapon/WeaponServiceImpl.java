package com.eldenringcalculator.weapon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eldenringcalculator.weapon.model.WeaponEntity;

@Service
@Transactional
public class WeaponServiceImpl implements WeaponService{
	
	@Autowired
	WeaponRepository weaponRepository;
	
	@Override
	public List<WeaponEntity> findAll() {

		return this.weaponRepository.findAll();
	}

}
