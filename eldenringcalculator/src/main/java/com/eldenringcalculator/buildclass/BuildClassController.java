package com.eldenringcalculator.buildclass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eldenringcalculator.buildclass.model.BuildClassDto;
import com.eldenringcalculator.config.mapper.BeanMapper;

@RequestMapping(value = "/buildclass")
@RestController
@CrossOrigin(origins = "*")
public class BuildClassController {

	@Autowired
	BuildClassService buildClassService;
	
	@Autowired
	BeanMapper beanMapper;
	
	@RequestMapping(path="", method = RequestMethod.GET)
	public List<BuildClassDto> get(){
		return this.beanMapper.mapList(buildClassService.findAll(), BuildClassDto.class);
	}
}
