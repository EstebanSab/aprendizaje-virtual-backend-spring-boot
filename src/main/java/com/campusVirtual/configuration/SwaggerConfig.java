package com.campusVirtual.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openApiConfig() {
		return new OpenAPI().info(apiInfo());
	}

	private Info apiInfo() {
		Info info = new Info();
		info.title("Java CAMPUS API")
		.description("API REST de campus virtual")
		.version("v1.0.0");
		return info;
	}
	
	
}