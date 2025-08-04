package com.naveen.projects.planfinity.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .cors() // ✅ Enable CORS
	        .and()
	        .csrf().disable()
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers(
	                new AntPathRequestMatcher("/register"),
	                new AntPathRequestMatcher("/login"),
	                new AntPathRequestMatcher("/events"),  // ✅ Allow events access
	                new AntPathRequestMatcher("/book"),
	                new AntPathRequestMatcher("/eventinfo/**"),
	                new AntPathRequestMatcher("/event")
	            ).permitAll()
	            .anyRequest().authenticated()
	        )
	        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

	    return http.build();
	}


	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
