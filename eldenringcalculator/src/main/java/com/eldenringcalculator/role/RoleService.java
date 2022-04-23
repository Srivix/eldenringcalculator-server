package com.eldenringcalculator.role;

import com.eldenringcalculator.role.model.RoleEntity;

public interface RoleService {
	
	RoleEntity findByName(String name);

}
