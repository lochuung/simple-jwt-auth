package com.huuloc.simplejwtauth;

import com.huuloc.simplejwtauth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimplejwtauthApplication {
	public static void main(String[] args) {
		SpringApplication.run(SimplejwtauthApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserService userService) {
		return args -> {
			userService.createTestingData();
		};
	}
}
