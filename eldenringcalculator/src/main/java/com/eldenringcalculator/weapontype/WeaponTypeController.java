package com.eldenringcalculator.weapontype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devonfw.module.beanmapping.common.api.BeanMapper;
import com.eldenringcalculator.weapontype.model.WeaponTypeDto;

@RequestMapping(value = "/weaponType")
@RestController
@CrossOrigin(origins = "*")
public class WeaponTypeController {
	
	@Autowired
	WeaponTypeService weaponTypeService;

	
	@Autowired
	BeanMapper beanMapper;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<WeaponTypeDto> get(){
		return beanMapper.mapList(weaponTypeService.findAll(), WeaponTypeDto.class);
	}


}
