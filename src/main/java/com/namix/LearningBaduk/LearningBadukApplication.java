package com.namix.LearningBaduk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication()
@PropertySource(value = { "classpath:secretApplication.properties" })
public class LearningBadukApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(LearningBadukApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LearningBadukApplication.class, args);
	}

}
