package com.eldenringcalculator.build;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.eldenringcalculator.build.model.BuildEntity;

public interface BuildRepository  extends CrudRepository<BuildEntity, Long>{
	
	@Query("select b from BuildEntity b where "
			+ "(b.createdby.username like '%'||:username||'%')"
			+ "and (b.name like '%'||:name||'%')"
			+ "and (:weapon1name is null or exists(select w from WeaponEntity w where b.weapon1.name like '%'||:weapon1name||'%'))"
			+ "and (:weapon2name is null or exists(select w from WeaponEntity w where b.weapon2.name like '%'||:weapon2name||'%'))"
			+ "and (b.created between :startDate and :endDate)"
			+ "and (b.state.name like 'PUBLIC'")
	@EntityGraph(attributePaths = {"weapon1", "weapon2", "weapon1.weaponType", "weapon2.weaponType", "buildclass", "createdby", "createdby.role", "state"})
	Page<BuildEntity> findPublicPage(@Param("username") String username, @Param("name") String name,
			@Param("weapon1name") String weapon1name, @Param("weapon2name") String weapon2name, 
		    @Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable pageable);
	
	@EntityGraph(attributePaths = {"weapon1", "weapon2",
			"weapon1.weaponType", "weapon2.weaponType", "buildclass", "createdby", "createdby.role", "state"})
	List<BuildEntity> findAll();
	
	@Query("select b from BuildEntity b where "
			+ "(b.createdby.username like '%'||:username||'%')"
			+ "and (b.name like '%'||:name||'%')"
			+ "and (:weapon1name is null or exists(select w from WeaponEntity w where b.weapon1.name like '%'||:weapon1name||'%'))"
			+ "and (:weapon2name is null or exists(select w from WeaponEntity w where b.weapon2.name like '%'||:weapon2name||'%'))"
			+ "and (b.created between :startDate and :endDate)")
	@EntityGraph(attributePaths = {"weapon1", "weapon2", "weapon1.weaponType", "weapon2.weaponType", "buildclass", "createdby", "createdby.role", "state"})
	Page<BuildEntity> findPageOfUser(@Param("username") String username, @Param("name") String name,
			@Param("weapon1name") String weapon1name, @Param("weapon2name") String weapon2name, 
		    @Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable pageable);

}
