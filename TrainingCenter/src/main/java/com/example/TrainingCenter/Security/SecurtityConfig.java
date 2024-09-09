package com.example.TrainingCenter.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurtityConfig {

	@Autowired
	JwtAuthEntryPoint authEntryPoint;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.csrf(csrf -> csrf.disable())
		.exceptionHandling()
		.authenticationEntryPoint(authEntryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests()
		.requestMatchers("/api/auth/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.httpBasic();
		
//		http.authorizeHttpRequests(auth -> auth
//                .requestMatchers("/").hasAnyAuthority("USER", "INSTRUCTOR", "STUDENT", "ADMIN")
//                .requestMatchers("/new").hasAnyAuthority("ADMIN", "CREATOR")
//                .requestMatchers("/edit/**").hasAnyAuthority("ADMIN", "EDITOR")
//                .requestMatchers("/delete/**").hasAuthority("ADMIN")
//                .anyRequest().authenticated()
//            )
//            .formLogin(login -> login.permitAll())
//            .logout(logout -> logout.permitAll())
//            .exceptionHandling(eh -> eh.accessDeniedPage("/403"))
//            ;
		 
		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	       
		
		return http.build();
	}
	
	
	@Bean
	public AuthenticationManager authenticationManager(
		AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter() {
        return new JWTAuthenticationFilter();
    }
	
}
