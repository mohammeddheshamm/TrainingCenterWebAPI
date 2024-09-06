package com.example.TrainingCenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages={
"com.example.TrainingCeter"})

@EnableJpaRepositories("com.example.TrainingCenter.Repository")
public class TrainingCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingCenterApplication.class, args);
	}

}
