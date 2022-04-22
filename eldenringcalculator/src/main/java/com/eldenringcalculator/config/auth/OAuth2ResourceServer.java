package com.eldenringcalculator.config.auth;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter
{
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
        	.authorizeRequests().antMatchers(HttpMethod.POST,"/build/{username}").access("hasAuthority('USER') && principal==#username")
        	.and().authorizeRequests().antMatchers(HttpMethod.PUT,"/build/").hasAuthority("USER")
        	.and().authorizeRequests().antMatchers(HttpMethod.PUT,"/build/{username}/{id}").access("hasAuthority('USER') && principal==#username")
        	.and().authorizeRequests().antMatchers(HttpMethod.POST, "/build/all").hasAuthority("ADMIN")
        	.anyRequest().permitAll();
	}
}