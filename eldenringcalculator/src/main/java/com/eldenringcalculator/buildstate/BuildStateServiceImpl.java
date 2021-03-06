package com.eldenringcalculator.buildstate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eldenringcalculator.buildstate.model.BuildStateEntity;

@Service
public class BuildStateServiceImpl implements BuildStateService{
	
	@Autowired
	BuildStateRepository buildStateRepository;
	
	@Override
	public BuildStateEntity findByName(String state) {
		return this.buildStateRepository.findByName(state);
	}

	@Override
	public List<BuildStateEntity> findAll() {
		return this.buildStateRepository.findAll();
	}

}
