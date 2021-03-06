package com.eldenringcalculator.weapon;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.eldenringcalculator.file.UploadFileService;
import com.eldenringcalculator.weapon.model.WeaponDto;
import com.eldenringcalculator.weapon.model.WeaponEntity;
import com.eldenringcalculator.weapontype.WeaponTypeService;
import com.eldenringcalculator.weapontype.model.WeaponTypeEntity;

@Service
public class WeaponServiceImpl implements WeaponService{
	
	@Autowired
	WeaponRepository weaponRepository;
	
	@Autowired
	WeaponTypeService weaponTypeService;
	
	@Autowired
	UploadFileService uploadFileService;
	
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
				response.put("error","No existe el arma.");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
		}
		
		if(dto.getPhoto()=="")
			dto.setPhoto("noPhoto.png");
		
		BeanUtils.copyProperties(dto, weapon, "id", "weapontype");
		
		if(dto.getWeaponType() == null) {
			response.put("mensaje", "No se ha introducido WeaponType.");
			response.put("error", "WeaponType not exists.");
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		WeaponTypeEntity weaponType = this.weaponTypeService.get(dto.getWeaponType().getId());
		
		if(weaponType==null) {
			response.put("mensaje", "No existe ese tipo de arma.");
			response.put("error", "WeaponType not exists.");
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}else
			weapon.setWeaponType(weaponType);
		
		
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

	@Override
	public ResponseEntity<?> uploadImage(MultipartFile file, String name) {

		Map<String, Object> response = new HashMap<>();
		
		WeaponEntity weapon = this.weaponRepository.findByName(name);
		
		if(weapon == null) {
			response.put("mensaje", "No existe esa Arma.");
			response.put("error","No existe el Arma.");
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(!file.isEmpty()) {
			String fileName = null;
			try {
				fileName = uploadFileService.copy(file);
			}catch(IOException e) {
				response.put("mensaje", "Error al subir la imagen del arma.");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			String oldFileName = weapon.getPhoto();
			
			uploadFileService.delete(oldFileName);
			
			weapon.setPhoto(fileName);
			
			this.weaponRepository.save(weapon);
			
			response.put("mensaje", "Se ha subido la imagen: "+fileName+" correctamente.");
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}else {
			response.put("mensaje", "El archivo est?? vac??o.");
			response.put("error","Archivo vac??o.");
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);	
		}	
	}

	@Override
	public Resource charge(String name) {
		
		try {
			return this.uploadFileService.charge(name);
		} catch(MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}

}