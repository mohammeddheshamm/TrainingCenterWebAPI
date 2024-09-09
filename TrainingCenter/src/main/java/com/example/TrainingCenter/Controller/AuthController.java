package com.example.TrainingCenter.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TrainingCenter.Entity.Dtos.AuthResponseDto;
import com.example.TrainingCenter.Entity.Dtos.LoginDto;
import com.example.TrainingCenter.Entity.Dtos.RegisterDto;
import com.example.TrainingCenter.Service.AuthenticationServiceImpl;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	
	@Autowired
	AuthenticationServiceImpl authService;
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto){
		return new ResponseEntity<>(new AuthResponseDto(authService.Login(loginDto)),HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
		return new ResponseEntity<>(authService.Register(registerDto),HttpStatus.OK);
	}
	
	
	
}
