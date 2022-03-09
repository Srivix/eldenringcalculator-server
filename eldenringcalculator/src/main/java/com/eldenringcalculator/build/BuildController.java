package com.eldenringcalculator.build;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eldenringcalculator.build.model.BuildDto;
import com.eldenringcalculator.build.model.BuildSearchDto;
import com.eldenringcalculator.config.mapper.BeanMapper;

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
		return this.beanMapper.mapList(buildService.findAll(), BuildDto.class);
	}
	
	@RequestMapping(path = {"", "/{id}"}, method = RequestMethod.PUT)
	public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody BuildDto dto) {
		
		this.buildService.save(id, dto);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public Page<BuildDto> findPage(@RequestBody BuildSearchDto dto){
		
		return this.beanMapper.mapPage(buildService.findPage(dto), BuildDto.class);
	}
}
