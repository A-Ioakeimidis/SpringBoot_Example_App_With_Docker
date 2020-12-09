package com.anastasios.spring.microservices.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootMicroservicesApplication extends SpringBootServletInitializer {

	/*
	 * Used when running as a JAR file
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroservicesApplication.class, args);
	}

	/*
	 * Used when running as a WAR file
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootMicroservicesApplication.class);
	}
}
