package com.jwt.example.JwtExample3.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.example.JwtExample3.Model.User;

public interface UserRepository extends JpaRepository<User, String>  {
	
	public Optional<User> findByEmail(String Email);
	

}
