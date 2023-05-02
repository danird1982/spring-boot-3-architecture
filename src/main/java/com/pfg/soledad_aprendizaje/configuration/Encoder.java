package com.pfg.soledad_aprendizaje.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Encoder {

	@Bean(name = "passwordEncoder")
	public BCryptPasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
}
