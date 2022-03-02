package com.eldenringcalculator.build;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eldenringcalculator.build.model.BuildDto;
import com.eldenringcalculator.build.model.BuildEntity;
import com.eldenringcalculator.weapon.WeaponService;

@Service
public class BuildServiceImpl implements BuildService{

	@Autowired
	BuildRepository buildRepository;
	
	@Autowired
	WeaponService weaponService;
	
	@Override
	public List<BuildEntity> findAll() {

		return this.buildRepository.findAll();
	}

	@Override
	public void save(Long id, BuildDto dto) {
		BuildEntity build = null;
		
		Boolean validated = true;
		
		if(id == null)
			build = new BuildEntity();
		else
			build = this.buildRepository.findById(id).orElse(null);
		
		BeanUtils.copyProperties(dto, build, "id", "weapon1", "weapon2");
		
		if(dto.getWeapon1()!=null)
			if(build.getDexterity()>=dto.getWeapon1().getDexreq() && build.getStrength()>=dto.getWeapon1().getStrengreq() && build.getIntelect()>=dto.getWeapon1().getIntreq())
				build.setWeapon1(weaponService.get(dto.getWeapon1().getId()));
			else
				validated = false;

		if(dto.getWeapon2()!=null)
			if(build.getDexterity()>=dto.getWeapon2().getDexreq() && build.getStrength()>=dto.getWeapon2().getStrengreq() && build.getIntelect()>=dto.getWeapon2().getIntreq())
				build.setWeapon2(weaponService.get(dto.getWeapon2().getId()));
			else
				validated = false;
		
		if(validated)
			this.buildRepository.save(build);
		else
			System.out.println("Atributo más bajo que el del arma.");
	}

}
