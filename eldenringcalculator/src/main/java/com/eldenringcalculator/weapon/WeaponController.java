package com.eldenringcalculator.weapon;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devonfw.module.beanmapping.common.api.BeanMapper;
import com.eldenringcalculator.file.UploadFileService;
import com.eldenringcalculator.weapon.model.WeaponDto;

@RequestMapping(value = "/weapon")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WeaponController {
	
	@Autowired
	WeaponService weaponService;
	
	@Autowired
	UploadFileService uploadFileService;
	
	@Autowired
	BeanMapper beanMapper;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<WeaponDto> get(){
		return beanMapper.mapList(weaponService.findAll(), WeaponDto.class);
	}
	
	@RequestMapping(path = "/uploads/img/{photoName:.+}", method = RequestMethod.GET)
	public Resource chargePhoto(@PathVariable String photoName) {
		
		Resource resource = null;
		try {
			resource = uploadFileService.charge(photoName);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return resource;
	}
	
	@RequestMapping(path = {"", "/{id}"}, method = RequestMethod.PUT)
	public ResponseEntity<?> save(@PathVariable(name = "id", required = false) Long id, @RequestBody WeaponDto dto) {
			
		return this.weaponService.save(dto, id);
	}

}
