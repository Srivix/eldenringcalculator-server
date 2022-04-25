package com.eldenringcalculator.buildstate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eldenringcalculator.buildstate.model.BuildStateDto;
import com.eldenringcalculator.config.mapper.BeanMapper;

@RequestMapping(value = "/buildstate")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BuildStateController {
	
	@Autowired
	BuildStateService buildStateService;
	
	@Autowired
	BeanMapper beanMapper;
	
	@RequestMapping(path="", method = RequestMethod.GET)
	public List<BuildStateDto> get(){
		return this.beanMapper.mapList(buildStateService.findAll(), BuildStateDto.class);
	}

}
