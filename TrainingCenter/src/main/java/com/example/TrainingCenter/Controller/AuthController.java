package com.example.TrainingCenter.Controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TrainingCenter.Entity.Role;
import com.example.TrainingCenter.Entity.User;
import com.example.TrainingCenter.Entity.Dtos.LoginDto;
import com.example.TrainingCenter.Entity.Dtos.RegisterDto;
import com.example.TrainingCenter.Repository.RoleRepository;
import com.example.TrainingCenter.Repository.UserRepository;
import com.example.TrainingCenter.Service.AuthenticationServiceImpl;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired 
	AuthenticationManager authManager;
	
	@Autowired
	UserRepository usrRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	PasswordEncoder passEncoder;
	
	@Autowired
	AuthenticationServiceImpl authService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
		
		return new ResponseEntity<>(authService.Login(loginDto),HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
		return new ResponseEntity<>(authService.Register(registerDto),HttpStatus.OK);
	}
	
	
	
}
