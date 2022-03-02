package com.eldenringcalculator.build;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devonfw.module.beanmapping.common.api.BeanMapper;
import com.eldenringcalculator.build.model.BuildDto;

@RequestMapping(value = "/build")
@RestController
@CrossOrigin(origins = "*")
public class BuildController {

	@Autowired
	BuildService buildService;
	
	@Autowired
	BeanMapper beanMapper;
	
	@RequestMapping(path ="", method = RequestMethod.GET)
	public List<BuildDto> get(){
		return beanMapper.mapList(buildService.findAll(), BuildDto.class);
	}
	
	@RequestMapping(path = {"", "/{id}"}, method = RequestMethod.PUT)
	public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody BuildDto dto) {
		
		buildService.save(id, dto);
	}
}
