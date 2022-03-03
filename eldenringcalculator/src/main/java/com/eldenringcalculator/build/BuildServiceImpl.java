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
		
		if(id == null)
			build = new BuildEntity();
		else
			build = this.buildRepository.findById(id).orElse(null);
		
		BeanUtils.copyProperties(dto, build, "id", "weapon1", "weapon2");
		
		if(validateRequirements(dto, build) && validateStats(build))
			this.buildRepository.save(build);
	}
	
	public Boolean validateRequirements(BuildDto dto, BuildEntity build) {
		
		if(dto.getWeapon1()!=null)
			if(build.getDexterity()>=dto.getWeapon1().getDexreq() && build.getStrength()>=dto.getWeapon1().getStrengreq() && build.getIntelect()>=dto.getWeapon1().getIntreq())
				build.setWeapon1(weaponService.get(dto.getWeapon1().getId()));
			else {
				System.out.println("Te falta estadistica en el arma 1 para poder equiparla");
				return false;
			}

		if(dto.getWeapon2()!=null)
			if(build.getDexterity()>=dto.getWeapon2().getDexreq() && build.getStrength()>=dto.getWeapon2().getStrengreq() && build.getIntelect()>=dto.getWeapon2().getIntreq())
				build.setWeapon2(weaponService.get(dto.getWeapon2().getId()));
			else {
				System.out.println("Te falta estadistica en el arma 2 para poder equiparla");
				return false;
			}
		
		return true;
	}
	
	public Boolean validateStats(BuildEntity build) {
		
		if(build.getDexterity()+build.getIntelect()+build.getStrength()==build.getLevel())		
			return true;
		else {
			System.out.println("La suma de atributos no suma con el nivel.");
			return false;
		}
	}

}
