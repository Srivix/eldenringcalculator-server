package com.eldenringcalculator.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eldenringcalculator.role.model.RoleEntity;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public RoleEntity findByName(String name) {

		return this.roleRepository.findByName(name);
	}

}
