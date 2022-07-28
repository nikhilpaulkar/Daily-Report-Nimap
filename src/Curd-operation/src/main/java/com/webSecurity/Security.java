package com.webSecurity;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter
{
	
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService());
}
@Bean
public PasswordEncoder passwordencoder()
{
	return NoOpPasswordEncoder.getInstance();
}
@Override
@Bean
protected AuthenticationManager authenticationManager() throws Exception {
	
	return super.authenticationManager();
}
@Override
protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable()
	.authorizeRequests()
	.antMatchers("/autheticate")
	.permitAll()
	.anyRequest()
	.authenticated();
}

}


