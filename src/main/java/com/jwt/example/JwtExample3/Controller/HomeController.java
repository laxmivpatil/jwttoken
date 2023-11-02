package com.jwt.example.JwtExample3.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.example.JwtExample3.Model.User;
import com.jwt.example.JwtExample3.Service.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	UserService userService; 
	
	@GetMapping("/users")
	public List<User> getUser()
	{
		System.out.println("Getting user Information");
		return userService.getUsers();
	}
	
	@GetMapping("/currentUser")
	public String getCurrentUser(Principal p)
	{
		System.out.println("Getting user Name");
		return p.getName();
	}
	

}
