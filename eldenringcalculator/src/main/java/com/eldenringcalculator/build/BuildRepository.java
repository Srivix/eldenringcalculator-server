package com.eldenringcalculator.build;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.eldenringcalculator.build.model.BuildEntity;

public interface BuildRepository  extends CrudRepository<BuildEntity, Long>{
	
	//@Query("select b from Build b")
	@EntityGraph(attributePaths = {"weapon1", "weapon2",
			"weapon1.weaponType", "weapon2.weaponType", "buildclass", "createdby", "createdby.role", "state"})
	Page<BuildEntity> findAll(Pageable pageable);
	
	@EntityGraph(attributePaths = {"weapon1", "weapon2",
			"weapon1.weaponType", "weapon2.weaponType", "buildclass", "createdby", "createdby.role", "state"})
	List<BuildEntity> findAll();

}
