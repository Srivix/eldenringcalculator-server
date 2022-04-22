package com.eldenringcalculator.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eldenringcalculator.user.model.UserEntity;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserEntity get(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUsername(username);
		
		if(user == null) {
			System.out.println("Error login no se encuentra usuario"+username);
			throw new UsernameNotFoundException("Excepcion Error login no se encuentra usuario"+username);
		}
		
		List<GrantedAuthority> authorities = user.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
		
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
		

	}

}
