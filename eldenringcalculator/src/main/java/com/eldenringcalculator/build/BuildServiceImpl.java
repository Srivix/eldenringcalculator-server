package com.eldenringcalculator.build;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.eldenringcalculator.build.model.BuildDto;
import com.eldenringcalculator.build.model.BuildEntity;
import com.eldenringcalculator.build.model.BuildSearchDto;
import com.eldenringcalculator.buildclass.BuildClassService;
import com.eldenringcalculator.buildstate.BuildStateService;
import com.eldenringcalculator.user.UserService;
import com.eldenringcalculator.weapon.WeaponService;

@Service
public class BuildServiceImpl implements BuildService{

	@Autowired
	BuildRepository buildRepository;
	
	@Autowired
	BuildStateService buildStateService;
	
	@Autowired
	WeaponService weaponService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	BuildClassService buildClassService;
	
	@Override
	public Page<BuildEntity> findPage(BuildSearchDto dto) {
		
		HashMap<String, Date> dates = processDates(dto.getStartDate(), dto.getEndDate());
		
		return this.buildRepository.findPublicPage(dto.getUsername(), dto.getName(), dto.getWeapon1name(),
				dto.getWeapon2name(), dates.get("startDate"), dates.get("endDate"),dto.getPageable());
	}
	
	@Override
	public Page<BuildEntity> findPageOfUser(String username, BuildSearchDto dto) {
		
		HashMap<String, Date> dates = processDates(dto.getStartDate(), dto.getEndDate());
		
		return this.buildRepository.findPageOfUser(username, dto.getName(), dto.getWeapon1name(),
				dto.getWeapon2name(), dates.get("startDate"), dates.get("endDate"), dto.getState(), dto.getPageable());
	}
	
	@Override
	public Page<BuildEntity> findPageOfAllBuilds(BuildSearchDto dto) {
		
		HashMap<String, Date> dates = processDates(dto.getStartDate(), dto.getEndDate());

		return this.buildRepository.findPageOfAllBuilds(dto.getUsername(), dto.getName(), dto.getWeapon1name(),
				dto.getWeapon2name(), dates.get("startDate"), dates.get("endDate"), dto.getState(), dto.getPageable());
	}
	
	public HashMap<String,Date> processDates(Date startDate, Date endDate){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		HashMap<String,Date> dates = new HashMap<String,Date>();
		
		 try {
	            if (startDate == null)
	                dates.put("startDate",format.parse("2020-01-01"));
	            else
	                dates.put("startDate",startDate);

	            if (endDate == null)
	                dates.put("endDate",format.parse("2099-12-31"));
	            else
	                dates.put("endDate",endDate);
	            
	        } catch (ParseException e) {
	            e.printStackTrace();
	            dates.put("startDate",startDate);
	            dates.put("endDate",endDate);
	        }
		 
		 return dates;
	}

	@Override
	public void save(Long id, BuildDto dto) {
		BuildEntity build = null;
		
		if(id == null)
			build = new BuildEntity();
		else
			build = this.buildRepository.findById(id).orElse(null);
		
		BeanUtils.copyProperties(dto, build, "id", "buildclass", "weapon1", "weapon2", "createdby", "state");

		build.setCreatedby(userService.findByUsername(dto.getCreatedby().getUsername()));
		build.setState(buildStateService.findByName(dto.getState().getName()));
		build.setBuildclass(buildClassService.findById(dto.getBuildclass().getId()));
		build.setWeapon1(weaponService.get(dto.getWeapon1().getId()));
		build.setWeapon2(weaponService.get(dto.getWeapon2().getId()));
		
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
