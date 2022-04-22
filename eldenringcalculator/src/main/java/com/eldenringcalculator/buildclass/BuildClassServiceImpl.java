package com.eldenringcalculator.buildclass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eldenringcalculator.buildclass.model.BuildClassEntity;

@Service
public class BuildClassServiceImpl implements BuildClassService{
	
	@Autowired
	BuildClassRepository buildClassRepository;

	@Override
	public List<BuildClassEntity> findAll() {

		return this.buildClassRepository.findAll();
	}

	@Override
	public BuildClassEntity findById(Long id) {
		return this.buildClassRepository.findById(id).orElse(null);
	}
	
	

}
