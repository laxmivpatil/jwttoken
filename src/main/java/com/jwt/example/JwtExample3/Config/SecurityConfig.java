package com.jwt.example.JwtExample3.Config;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jwt.example.JwtExample3.Security.JwtAuthenticationEntryPoint;
import com.jwt.example.JwtExample3.Security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {


	@Autowired 
	private UserDetailsService userDetailsService;
	@Autowired 
	private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
/*
    	http
        .csrf().disable()
        .cors().disable()
        .authorizeRequests()
            .antMatchers("/home/**").authenticated()
            .antMatchers("/auth/login").permitAll()
            .anyRequest().authenticated()
            .and()
        .exceptionHandling()
            .authenticationEntryPoint(point)
            .and()
        .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);       */
    	http
        .csrf().disable()
        .cors().disable()
        .authorizeRequests()
            .antMatchers("/home/**").authenticated()
            .antMatchers("/auth/login").permitAll()
            .antMatchers("/auth/create-user").permitAll()
            .anyRequest().authenticated()
            .and()
        .exceptionHandling()
            .authenticationEntryPoint(point)
            .and()
        .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

 
http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
return http.build();
    }
    
   @Bean 
    public DaoAuthenticationProvider doDaoAuthenticationProvider() {
	   
	   DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
	   daoAuthenticationProvider.setUserDetailsService(userDetailsService);
	   daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
	   return daoAuthenticationProvider;
    	
    }


}