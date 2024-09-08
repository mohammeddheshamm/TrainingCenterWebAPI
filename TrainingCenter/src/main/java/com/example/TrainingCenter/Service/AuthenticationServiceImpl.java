package com.example.TrainingCenter.Service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.TrainingCenter.Entity.Role;
import com.example.TrainingCenter.Entity.User;
import com.example.TrainingCenter.Entity.Dtos.LoginDto;
import com.example.TrainingCenter.Entity.Dtos.RegisterDto;
import com.example.TrainingCenter.Exception.UsernameAlreadyTaken;
import com.example.TrainingCenter.Repository.RoleRepository;
import com.example.TrainingCenter.Repository.UserRepository;

@Service
public class AuthenticationServiceImpl {

	@Autowired 
	AuthenticationManager authManager;
	
	@Autowired
	UserRepository usrRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	PasswordEncoder passEncoder;
	
	public String Login(LoginDto loginDto) {
		Authentication authentication = authManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginDto.getUsername(),
						loginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "User logged in Successfully";
	}
	
	public String Register(RegisterDto registerDto) {
		if(usrRepo.existsByUsername(registerDto.getUsername())) {
			 throw new UsernameAlreadyTaken("Username already taken.");
		}
		
		User user = new User();
		user.setUserName(registerDto.getUsername());
		user.setPassword(passEncoder.encode((registerDto.getPassword())));
		user.setEmail(registerDto.getEmail());
		user.setPhoneNumber(registerDto.getPhoneNumber());
		
		Role roles = roleRepo.findByName("USER").get();
		
		user.setRoles(Collections.singletonList(roles));
		
		usrRepo.save(user);
		return "User Registered Successfully";
	}
	
}
