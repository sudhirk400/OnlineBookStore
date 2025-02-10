package com.sudhirk400.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

/**
 * don't use KeycloakWebSecurityConfigurerAdapter it extends
 * WebSecurityConfigurerAdapter which is deprecated.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(jsr250Enabled = true) // allows using the @RolesAllowed
											// annotation
public class WebSecurityConfig {

	/**
	 * Session authentication strategy.
	 *
	 * @return the session authentication strategy
	 */
	@Bean
	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
		return new RegisterSessionAuthenticationStrategy(
				new SessionRegistryImpl());
	}

	/**
	 * Filter chain.
	 *
	 * @param http
	 *            the http
	 * @return the security filter chain
	 * @throws Exception
	 *             the exception
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		/*
		 * any endpoint that does not require a specific role (is not
		 * having @RolesAllowed annotation) can be accessed only by
		 * authenticated user
		 */
		/*
		 * http.authorizeHttpRequests() .anyRequest() .authenticated();
		 * 
		 * http.authorizeRequests(authorize -> authorize
		 * .anyRequest().authenticated() // Any request must be authenticated );
		 */
		http.authorizeHttpRequests(authorize -> authorize
				// Allow unrestricted access to Swagger UI and OpenAPI
				// documentation
				.requestMatchers("/swagger-ui.html", "/swagger-ui/**",
						"/v3/api-docs/**", "/swagger-resources/**",
						"/webjars/**")
				.permitAll()
				// Require authentication for all other requests
				.anyRequest().authenticated());

		// Configure OAuth2 Resource Server with JWT
		http.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt
				.jwtAuthenticationConverter(jwtAuthenticationConverter())));

		// add configuration of authorization based on roles to
		// oauth2ResourceServer
		// http.oauth2ResourceServer()
		// .jwt()
		// .jwtAuthenticationConverter(jwtAuthenticationConverter());

		return http.build();
	}

	/**
	 * Jwt authentication converter.
	 *
	 * @return the jwt authentication converter
	 */
	private JwtAuthenticationConverter jwtAuthenticationConverter() {
		JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
		jwtConverter.setJwtGrantedAuthoritiesConverter(
				new GrantedAuthoritiesConverter());
		return jwtConverter;
	}

}