package com.task.assignment.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class ApplicationDocConfig {

	Contact contact() {
		return new Contact().name("Mallikarjun Chonde")
				.email("mallikarjunchonde89@gmail.com")
				.url("github.com/MallikarjunChonde");
	}

	Info info() {
		return new Info().title("Trade Management system")
				.version("V1")
				.description("A simple RESTful API for Trade Management")
				.contact(contact());
	}

	@Bean
	OpenAPI openApi() {
		return new OpenAPI().info(info());
	}
}