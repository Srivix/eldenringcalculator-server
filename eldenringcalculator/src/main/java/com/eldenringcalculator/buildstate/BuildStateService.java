package com.eldenringcalculator.buildstate;

import com.eldenringcalculator.buildstate.model.BuildStateEntity;

public interface BuildStateService {
	
	BuildStateEntity findByName(String state);

}
