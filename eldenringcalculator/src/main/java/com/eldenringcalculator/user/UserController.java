package com.eldenringcalculator.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eldenringcalculator.user.model.UserSaveDto;

@RequestMapping(value = "/user")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping(path = "/register", method = RequestMethod.PUT)
	public ResponseEntity<?> register(@RequestBody UserSaveDto user){
		
		return this.userService.save(user);
	}
	
}
