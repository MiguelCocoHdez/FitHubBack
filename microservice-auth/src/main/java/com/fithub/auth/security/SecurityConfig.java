package com.fithub.auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fithub.auth.jwt.JwtAuthenticationFilter;
import com.fithub.auth.jwt.JwtEntryPoint;
import com.fithub.auth.jwt.JwtUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private JwtUtil ju;

    public SecurityConfig(JwtUtil ju) {
        this.ju = ju;
    }

	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.cors(Customizer.withDefaults())
			.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests(auth -> auth.requestMatchers("fithub/auth/register", "fithub/auth/login").permitAll()
			.anyRequest().authenticated())
			.httpBasic(Customizer.withDefaults())
			.exceptionHandling(excepcion -> excepcion.authenticationEntryPoint(jwtEntryPoint()))
			.addFilterBefore(new JwtAuthenticationFilter(ju), UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
    }
	
	@Bean
	JwtEntryPoint jwtEntryPoint() {
		return new JwtEntryPoint();
	}
	
	@Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
