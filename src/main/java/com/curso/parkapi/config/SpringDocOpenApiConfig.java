package com.curso.parkapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringDocOpenApiConfig {
	@Bean
	public OpenAPI openApi() {
		return new OpenAPI().info(
					new Info()
					.title("REST API - Spring Park")
					.description("API para gestão de estacionamento de veículos")
					.version("v1")
				);
				
	}
}
