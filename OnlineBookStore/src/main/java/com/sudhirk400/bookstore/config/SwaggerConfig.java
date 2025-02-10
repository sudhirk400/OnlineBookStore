package com.sudhirk400.bookstore.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The Class SwaggerConfig.
 */
@Configuration
public class SwaggerConfig {

	/**
	 * Custom open API.
	 *
	 * @return the open API
	 */
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title("My API").version("1.0")
				.description("API documentation for My Application"));
	}
}