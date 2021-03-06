package com.eldenringcalculator.weapon;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import com.eldenringcalculator.weapon.model.WeaponEntity;

public interface WeaponRepository extends CrudRepository<WeaponEntity, Long>{
	
	@EntityGraph(attributePaths= {"weaponType"})
	List<WeaponEntity> findAll();

	WeaponEntity findByName(String name);

}
