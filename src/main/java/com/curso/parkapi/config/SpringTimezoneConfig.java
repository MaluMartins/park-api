package com.curso.parkapi.config;

import java.util.TimeZone;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringTimezoneConfig {
	public void timezoneConfig() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}
}
