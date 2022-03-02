package com.eldenringcalculator.build;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import com.eldenringcalculator.build.model.BuildEntity;

public interface BuildRepository  extends CrudRepository<BuildEntity, Long>{
	
	@EntityGraph(attributePaths = {"weapon1", "weapon2",
			"weapon1.weaponType", "weapon2.weaponType"})
	List<BuildEntity> findAll();

}
