package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated())
        .headers(headers -> headers.frameOptions().disable())
        .csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**","/**"))
        .httpBasic();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
            UserDetails user = User.builder()
                    .username("user")
                    .password("{noop}password") // noop means no password encoding
                    .roles("USER")
                    .build();
            return new InMemoryUserDetailsManager(user);
    }

}
