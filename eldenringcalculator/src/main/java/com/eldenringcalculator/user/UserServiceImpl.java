package com.eldenringcalculator.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eldenringcalculator.role.RoleService;
import com.eldenringcalculator.role.model.RoleEntity;
import com.eldenringcalculator.user.model.UserEntity;
import com.eldenringcalculator.user.model.UserSaveDto;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserEntity findByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Excepcion Error login no se encuentra usuario"+username);
		}
		
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
		
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
		

	}

	@Override
	public ResponseEntity<?> save(UserSaveDto dto) {
		
		Map<String, Object> response = new HashMap<>();
		
		UserEntity user = new UserEntity();
		
		BeanUtils.copyProperties(dto, user,"password");
		
		if(dto.getPassword().length()<8) {
			response.put("mensaje", "Password muy corto.");
			response.put("error","Password muy corto.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);	
		}
		
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		
		List<RoleEntity> roles = new ArrayList<RoleEntity>();
		
		RoleEntity role = this.roleService.findByName("USER");
		roles.add(role);
		user.setRoles(roles);
		
		try {
			this.userRepository.save(user);
			
			response.put("mensaje", "Usuario registrado con éxito.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}catch(Exception e) {
			response.put("mensaje", "Usuario o Email no disponibles.");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
