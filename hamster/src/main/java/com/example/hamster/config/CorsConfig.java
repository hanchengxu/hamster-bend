package com.example.hamster.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

	@Value("#{'${cros.allowed.origin}'.split(',')}") 
	private List<String> originsVal;

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		this.addAllowedOrigins(corsConfiguration);
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		corsConfiguration.setAllowCredentials(true);
		source.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(source);
	}

	private void addAllowedOrigins(CorsConfiguration corsConfiguration) {
		for (String origin : originsVal) {
			corsConfiguration.addAllowedOrigin("http://" + origin);
			corsConfiguration.addAllowedOrigin("https://" + origin);
		}
	}
}
