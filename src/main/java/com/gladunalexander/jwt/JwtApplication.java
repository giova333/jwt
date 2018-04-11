package com.gladunalexander.jwt;

import com.gladunalexander.jwt.user.User;
import com.gladunalexander.jwt.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(JWTProperties.class)
public class JwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

	@Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
	    return args -> userRepository.save(new User("admin", "admin", "Admin"));
    }
}


