package com.cropDetails.User.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cropDetails.User.Jwt.EntryPointJwt;
import com.cropDetails.User.Jwt.TokenFilter;
import com.cropDetails.User.SecurityService.UserDetailsServiceImpl;

@Configuration

@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SecurityConfig {
	@Autowired
	EntryPointJwt entryPoint;
	@Autowired
	TokenFilter tokenFilter;
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Bean
	public DaoAuthenticationProvider authenticate() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	@Bean
	public SecurityFilterChain doFilter(HttpSecurity http) throws Exception {

//		return http

//				.csrf().disable()

//				.exceptionHandling()

//				.authenticationEntryPoint(entryPoint)

//				.and()

//				.authorizeHttpRequests()

//				.requestMatchers("/app/**").permitAll()

//				.requestMatchers("/ticketbookingapp/**").authenticated()

//				.and()

//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

//				.and()

//				.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class)

//				.build();

		return http
				.csrf().disable()
				.exceptionHandling()
				.authenticationEntryPoint(entryPoint)
				.and()
				.authorizeHttpRequests()
				.requestMatchers("/v3/**", "swagger-ui/**", "/app/**", "/user/register","/error","user/isDealer/**","user/viewById/**" )
				.permitAll()
				.requestMatchers("/crop/**","/user/**","/invoice/**").authenticated()
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}