package com.challenges.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RedisApplication {
	@RequestMapping("/")
	public String home(){
		return "home";
	}
	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

}