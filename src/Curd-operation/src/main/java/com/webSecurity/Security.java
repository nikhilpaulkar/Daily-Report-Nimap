package com.webSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter
{
	@Autowired
	private AuthenticationUserDetailsService customuserdetailsservice;
	@Autowired
	private JwtAutheticationEntryPoint jwtautheticationentrypoint;
	@Autowired
	private JwtFilter jwtfilter;
	
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception
{
	auth.userDetailsService(this.userDetailsService()).passwordEncoder(passwordencoder());
}
@Bean
public PasswordEncoder passwordencoder()
{
	return new BCryptPasswordEncoder();
}
@Override
@Bean
public AuthenticationManager authenticationManagerBean() throws Exception {
	
	return super.authenticationManagerBean();
}
@Override
protected void configure(HttpSecurity http) throws Exception
{
	 http.csrf()
	.disable()
	.authorizeHttpRequests()
	.anyRequest()
	.authenticated()
	.and()
	.exceptionHandling()
	.authenticationEntryPoint(this.jwtautheticationentrypoint);
}


}


