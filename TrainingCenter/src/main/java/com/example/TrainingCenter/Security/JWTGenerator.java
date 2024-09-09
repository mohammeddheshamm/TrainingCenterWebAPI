package com.example.TrainingCenter.Security;

import java.security.Key;
import java.util.Date;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTGenerator {

	private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	
	public String generateToken(Authentication authentication) {
		String username = authentication.getName();
		Date currentDate = new Date();
		Date expireDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION);
		
		String token = Jwts.builder()
						.setSubject(username)
						.setIssuedAt(currentDate)
						.setExpiration(expireDate)
						.signWith(SignatureAlgorithm.HS512, key)
						.compact();
		return token;
	}

	public String getUsernameFromToken(String token) {
		Claims claims = Jwts.parser()
								.setSigningKey(key)
								.parseClaimsJws(token)
								.getBody();
		return claims.getSubject();
	}
	
	
	public Boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(key).parseClaimsJws(token);
			return true;
		}catch(Exception ex) {
			throw new AuthenticationCredentialsNotFoundException("JWT is incorrect or expired");
		}
	}
	
}
