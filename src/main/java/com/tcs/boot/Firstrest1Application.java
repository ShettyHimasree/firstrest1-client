package com.tcs.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Firstrest1Application {

	public static void main(String[] args) {
		SpringApplication.run(Firstrest1Application.class, args);
		System.out.println("making changes again!!!!!");
	}
@Bean
RestTemplate createTemplate() {
	RestTemplate createTemplate;
	return new RestTemplate();
}
}
