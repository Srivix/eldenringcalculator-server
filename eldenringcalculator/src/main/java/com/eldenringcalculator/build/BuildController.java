package com.eldenringcalculator.build;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@CrossOrigin(origins = "http://localhost:4200/")
public class BuildController {

	@Autowired
	BuildService buildService;
	
	@Autowired
	BeanMapper beanMapper;
	
	@RequestMapping(path = {"", "/{id}"}, method = RequestMethod.PUT)
	public ResponseEntity<?> save(@PathVariable(name = "id", required = false) Long id, @RequestBody BuildDto dto, Principal principal) {
		
		return this.buildService.save(id, dto, principal.getName());
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<?> findPage(@RequestBody BuildSearchDto dto){
		
		HashMap<String, Object> response = buildService.findPage(dto);
		Page<BuildDto> page = null;
		
		if(response.get("page")!=null) {
			page = this.beanMapper.mapPage((Page<?>) response.get("page"), BuildDto.class);
			return new ResponseEntity<Page<BuildDto>>(page, HttpStatus.OK);
		}
		else
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public ResponseEntity<?> findPageOfUser(Principal principal, @RequestBody BuildSearchDto dto){
		
		HashMap<String, Object> response = buildService.findPageOfUser(principal.getName(), dto);
		Page<BuildDto> page = null;
		
		if(response.get("page")!=null) {
			page = this.beanMapper.mapPage((Page<?>) response.get("page"), BuildDto.class);
			return new ResponseEntity<Page<BuildDto>>(page, HttpStatus.OK);
		}
		else
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
	@RequestMapping(path ="/all", method = RequestMethod.POST)
	public ResponseEntity<?> findPageOfAllBuilds(@RequestBody BuildSearchDto dto){

		HashMap<String, Object> response = buildService.findPageOfAllBuilds(dto);
		Page<BuildDto> page = null;
		
		if(response.get("page")!=null) {
			page = this.beanMapper.mapPage((Page<?>) response.get("page"), BuildDto.class);
			return new ResponseEntity<Page<BuildDto>>(page, HttpStatus.OK);
		}
		else
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") Long id, Principal principal) {
		
		return this.buildService.delete(id, principal.getName());
	}
}
