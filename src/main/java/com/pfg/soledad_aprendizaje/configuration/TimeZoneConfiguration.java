package com.pfg.soledad_aprendizaje.configuration;

import java.util.TimeZone;

import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class TimeZoneConfiguration {

	@PostConstruct
	void started() {
	  TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}
