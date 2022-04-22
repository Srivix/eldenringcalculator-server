package com.eldenringcalculator.build;

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
	
	@RequestMapping(path = {"", "/{id}"}, method = RequestMethod.PUT)
	public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody BuildDto dto) {
		
		this.buildService.save(id, dto);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public Page<BuildDto> findPage(@RequestBody BuildSearchDto dto){
		
		return this.beanMapper.mapPage(buildService.findPage(dto), BuildDto.class);
	}
	
	@RequestMapping(path = "/{username}", method = RequestMethod.POST)
	public Page<BuildDto> findPageOfUser(@PathVariable(name = "username") String username, @RequestBody BuildSearchDto dto){
		
		return this.beanMapper.mapPage(buildService.findPageOfUser(username, dto), BuildDto.class);
	}
	
	@RequestMapping(path ="/all", method = RequestMethod.POST)
	public Page<BuildDto> findPageOfAllBuilds(@RequestBody BuildSearchDto dto){
		return this.beanMapper.mapPage(buildService.findPageOfAllBuilds(dto), BuildDto.class);
	}
}
