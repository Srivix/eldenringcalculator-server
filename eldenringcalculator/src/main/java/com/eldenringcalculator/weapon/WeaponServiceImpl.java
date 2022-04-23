package com.eldenringcalculator.weapon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eldenringcalculator.weapon.model.WeaponDto;
import com.eldenringcalculator.weapon.model.WeaponEntity;
import com.eldenringcalculator.weapontype.WeaponTypeService;

@Service
public class WeaponServiceImpl implements WeaponService{
	
	@Autowired
	WeaponRepository weaponRepository;
	
	@Autowired
	WeaponTypeService weaponTypeService;
	
	@Override
	public List<WeaponEntity> findAll() {

		return this.weaponRepository.findAll();
	}

	@Override
	public WeaponEntity get(Long id) {

		return this.weaponRepository.findById(id).orElse(null);
	}

	@Override
	public ResponseEntity<?> save(WeaponDto dto, Long id) {
		
		WeaponEntity weapon = null;
		Map<String, Object> response = new HashMap<>();
		
		if(id == null)
			weapon = new WeaponEntity();
		else {
			weapon = this.weaponRepository.findById(id).orElse(null);
			if(weapon==null) {
				response.put("mensaje", "No existe el arma.");
				
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
		}
		
		BeanUtils.copyProperties(dto, weapon, "id", "weapontype");
		
		weapon.setWeaponType(weaponTypeService.get(dto.getWeaponType().getId()));
		
		if(weapon.getWeaponType()==null) {
			response.put("mensaje", "No existe ese tipo de arma.");
			response.put("error", "WeaponType not exists.");
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		
		try {
			this.weaponRepository.save(weapon);
		}catch(DataAccessException e) {
			response.put("mensaje", "No se ha podido guardar el arma en la base de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Arma guardada.");
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
	}

}
