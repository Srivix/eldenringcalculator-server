package com.eldenringcalculator.weapon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devonfw.module.beanmapping.common.api.BeanMapper;
import com.eldenringcalculator.weapon.model.WeaponDto;

@RequestMapping(value = "/weapon")
@RestController
@CrossOrigin(origins = "*")
public class WeaponController {
	
	@Autowired
	WeaponService weaponService;
	
	@Autowired
	BeanMapper beanMapper;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<WeaponDto> get(){
		return beanMapper.mapList(weaponService.findAll(), WeaponDto.class);
	}

}
