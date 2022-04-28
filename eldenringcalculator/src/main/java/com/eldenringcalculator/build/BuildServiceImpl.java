package com.eldenringcalculator.build;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eldenringcalculator.build.model.BuildDto;
import com.eldenringcalculator.build.model.BuildEntity;
import com.eldenringcalculator.build.model.BuildSearchDto;
import com.eldenringcalculator.buildclass.BuildClassService;
import com.eldenringcalculator.buildclass.model.BuildClassEntity;
import com.eldenringcalculator.buildstate.BuildStateService;
import com.eldenringcalculator.buildstate.model.BuildStateEntity;
import com.eldenringcalculator.user.UserService;
import com.eldenringcalculator.user.model.UserEntity;
import com.eldenringcalculator.weapon.WeaponService;
import com.eldenringcalculator.weapon.model.WeaponEntity;

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
	public HashMap<String, Object> findPage(BuildSearchDto dto) {
		
		HashMap<String, Object> response = new HashMap<>();
		
		HashMap<String, Date> dates = processDates(dto.getStartDate(), dto.getEndDate());
		
		try {
			if(dto.getPageable()!=null) {
				Page<BuildEntity> page = this.buildRepository.findPublicPage(dto.getUsername(), dto.getName(), dto.getWeapon1name(),
						dto.getWeapon2name(), dates.get("startDate"), dates.get("endDate"),dto.getPageable());
				
				response.put("page", page);
			}else{
				response.put("page", null);
				response.put("mensaje", "El json de paginación está vacío.");
			}
		
		}catch(DataAccessException e) {
			response.put("page", null);
			response.put("mensaje", "La propiedad de ordenación no es correcta.");
			response.put("error", "La propiedad de ordenación es incorrecta.");
			
		}
		
		return response;
	}
	
	@Override
	public HashMap<String, Object> findPageOfUser(String username, BuildSearchDto dto) {
		
		HashMap<String, Object> response = new HashMap<>();
		
		HashMap<String, Date> dates = processDates(dto.getStartDate(), dto.getEndDate());
		
		try {
			if(dto.getPageable()!=null) {
				Page<BuildEntity> page = this.buildRepository.findPageOfUser(username, dto.getName(), dto.getWeapon1name(),
						dto.getWeapon2name(), dates.get("startDate"), dates.get("endDate"), dto.getState(), dto.getPageable());
				
				response.put("page", page);
			}else{
				response.put("page", null);
				response.put("mensaje", "El json de paginación está vacío.");
				response.put("error", "El json de paginación está vacío.");
			}
		
		}catch(DataAccessException e) {
			response.put("page", null);
			response.put("mensaje", "La propiedad de ordenación no es correcta.");
			response.put("error", "La propiedad de ordenación no es correcta.");
			
		}
		
		return response;
	}
	
	@Override
	public HashMap<String, Object> findPageOfAllBuilds(BuildSearchDto dto) {
		
		HashMap<String, Object> response = new HashMap<>();
		
		HashMap<String, Date> dates = processDates(dto.getStartDate(), dto.getEndDate());
		
		try {
			if(dto.getPageable()!=null) {
				Page<BuildEntity> page = this.buildRepository.findPageOfAllBuilds(dto.getUsername(), dto.getName(), dto.getWeapon1name(),
						dto.getWeapon2name(), dates.get("startDate"), dates.get("endDate"), dto.getState(), dto.getPageable());
				
				response.put("page", page);
			}else{
				response.put("page", null);
				response.put("mensaje", "El json de paginación está vacío.");
				response.put("error", "El json de paginación está vacío.");
			}
		
		}catch(DataAccessException e) {
			response.put("page", null);
			response.put("mensaje", "La propiedad de ordenación no es correcta.");
			response.put("error", "La propiedad de ordenación no es correcta");			
		}
		
		return response;
		
	}
	
	public HashMap<String,Date> processDates(Date startDate, Date endDate){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		HashMap<String,Date> dates = new HashMap<String,Date>();
		
		if(startDate !=null && endDate !=null)
			if(startDate.getTime()>endDate.getTime())
			{
				Date date = startDate;
				startDate = endDate;
				endDate = date;
			}
		
		try{
            if (startDate == null)
                dates.put("startDate",format.parse("2020-01-01"));
            else
                dates.put("startDate",startDate);

            if (endDate == null)
                dates.put("endDate",format.parse("2099-12-31"));
            else
                dates.put("endDate",endDate);
         
        }catch (ParseException e) {
            e.printStackTrace();
            dates.put("startDate",startDate);
            dates.put("endDate",endDate);
	    }
		 
		 return dates;
	}

	@Override
	public ResponseEntity<?> save(Long id, BuildDto dto, String username) {
		
		BuildEntity build = null;
		Map<String, Object> response = new HashMap<>();
		
		if(id == null) {
			build = new BuildEntity();
			
			UserEntity user = userService.findByUsername(username);
			
			if(user==null) {
				response.put("mensaje", "No existe ese usuario.");
				response.put("error", "CreatedBy not exists.");
				
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}else
				build.setCreatedby(user);
			
		}else {

			build = this.buildRepository.findById(id).orElse(null);
			if(build==null) {
				response.put("mensaje", "No existe la build.");
				response.put("error", "Build not exists.");
				
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
				
			if(!build.getCreatedby().getUsername().equals(username)) {
				response.put("mensaje", "El usuario no es el dueño de esta Build.");
				response.put("error", "El usuario no es el dueño de esta Build.");
				
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.UNAUTHORIZED);
			}
				 
		}

		BeanUtils.copyProperties(dto, build, "id", "buildclass", "weapon1", "weapon2", "createdby", "state");
		
		if(dto.getState() == null) {
			response.put("mensaje", "No se ha introducido Estado.");
			response.put("error", "State not exists.");
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		BuildStateEntity buildState = buildStateService.findByName(dto.getState().getName());
		
		if(buildState==null) {
			response.put("mensaje", "No existe ese tipo de estado.");
			response.put("error", "State not exists.");
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}else
			build.setState(buildState);
		
		if(dto.getBuildclass() == null) {
			response.put("mensaje", "No se ha introducido BuildClass.");
			response.put("error", "BuildClass not exists.");
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		BuildClassEntity buildClass = buildClassService.findById(dto.getBuildclass().getId());
		
		if(buildClass==null) {
			response.put("mensaje", "No existe ese tipo de clase.");
			response.put("error", "BuildClass not exists.");
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}else
			build.setBuildclass(buildClass);
		
		if(dto.getWeapon1()==null)
			build.setWeapon1(null);
		else {
			WeaponEntity weapon1 = weaponService.get(dto.getWeapon1().getId());
			
			if(weapon1 == null) {
				response.put("mensaje", "No existe el arma 1.");
				response.put("error", "Weapon1 not exists.");
				
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}else
				build.setWeapon1(weapon1);
		}
		
		if(dto.getWeapon2()==null)
			build.setWeapon2(null);
		else {
			WeaponEntity weapon2 = weaponService.get(dto.getWeapon2().getId());
			
			if(weapon2 == null) {
				response.put("mensaje", "No existe el arma 2.");
				response.put("error", "Weapon2 not exists.");
				
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}else
				build.setWeapon2(weapon2);
		}
		
		if(!validateStats(build)) {
			response.put("mensaje", "Las estadisticas no son correctas.");
			response.put("error", "Las estadisticas no son correctas.");
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(!validateRequirements(build)){
			response.put("mensaje", "La build no cumple con los requisitos de un arma.");
			response.put("error", "La build no cumple con los requisitos de un arma.");
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			this.buildRepository.save(build);
			response.put("mensaje", "Build guardada.");
			
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
		}catch(DataAccessException e) {
			response.put("mensaje", "No se ha podido guardar la build en la base de datos.");
			response.put("error", "No se ha podido guardar la build en la base de datos.");
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public Boolean validateRequirements(BuildEntity build) {
		
		if(build.getWeapon1()!=null)
			if(build.getDexterity()<build.getWeapon1().getDexReq() || build.getStrength()<build.getWeapon1().getStrengReq() || build.getIntelect()<build.getWeapon1().getIntReq() 
					|| build.getArcane()<build.getWeapon1().getArcaneReq() || build.getFaith()<build.getWeapon1().getFaithReq()) 
				return false;

		if(build.getWeapon2()!=null)
			if(build.getDexterity()<build.getWeapon2().getDexReq() || build.getStrength()<build.getWeapon2().getStrengReq() || build.getIntelect()<build.getWeapon2().getIntReq() 
					|| build.getArcane()<build.getWeapon2().getArcaneReq() || build.getFaith()<build.getWeapon2().getFaithReq())
				return false;
			
		
		return true;
	}
	
	public Boolean validateStats(BuildEntity build) {
		
		Integer buildClassStatsCount = build.getBuildclass().getDexterity()+build.getBuildclass().getStrength()
				+build.getBuildclass().getIntelect()+build.getBuildclass().getFaith()+build.getBuildclass().getArcane();

		Integer buildStatsCount = (build.getDexterity()+build.getIntelect()+build.getStrength()+build.getFaith()+build.getArcane())-buildClassStatsCount;

		Integer buildLevel = build.getLevel()-build.getBuildclass().getLevel();

		if(buildStatsCount.equals(buildLevel))		
			return true;
		
		return false;
	}

	@Override
	public ResponseEntity<?> delete(Long id, String username) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			if(this.buildRepository.findById(id).orElse(null).getCreatedby().getUsername().equals(username)){
				this.buildRepository.deleteById(id);
				response.put("mensaje", "Build borrada.");
				
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
			}else{
				response.put("mensaje", "No eres el dueño de la build.");
				response.put("error","No eres el dueño de la build.");
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.UNAUTHORIZED);
			}
		}catch(NullPointerException e) {
			response.put("mensaje", "No existe la build.");
			response.put("error","Build: "+e.toString());
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
