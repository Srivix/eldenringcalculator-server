package com.eldenringcalculator.weapon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.devonfw.module.beanmapping.common.api.BeanMapper;
import com.eldenringcalculator.weapon.model.WeaponDto;

@RequestMapping(value = "/weapon")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class WeaponController {
	
	@Autowired
	WeaponService weaponService;
	
	@Autowired
	BeanMapper beanMapper;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<WeaponDto> get(){
		return beanMapper.mapList(weaponService.findAll(), WeaponDto.class);
	}
	
	@RequestMapping(path = "/uploads/{photoName:.+}", method = RequestMethod.GET)
	public Resource chargePhoto(@PathVariable String photoName) {
		return this.weaponService.charge(photoName);
	}
	
	@RequestMapping(path = "/upload", method = RequestMethod.PUT)
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file, @RequestParam("name") String name){	
		return this.weaponService.uploadImage(file, name);
	}
	
	@RequestMapping(path = {"", "/{id}"}, method = RequestMethod.PUT)
	public ResponseEntity<?> save(@PathVariable(name = "id", required = false) Long id, @RequestBody WeaponDto dto) {	
		return this.weaponService.save(dto, id);
	}

}
