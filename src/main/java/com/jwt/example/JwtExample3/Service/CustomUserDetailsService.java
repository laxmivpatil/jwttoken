package com.jwt.example.JwtExample3.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.example.JwtExample3.Model.User;
import com.jwt.example.JwtExample3.Repository.UserRepository;

@Service
public class CustomUserDetailsService  implements UserDetailsService{

	
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("hi ");
	User user=	userRepository.findByEmail(username).orElseThrow(()->new RuntimeException());
	//	User user=	userRepository.findByEmail(username).get();
		
		
		//load user from db
		return user;
	}
	
	
	

}
