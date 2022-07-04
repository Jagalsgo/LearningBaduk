package com.namix.LearningBaduk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = { "classpath:secretApplication.properties" })
public class LearningBadukApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningBadukApplication.class, args);
	}

}
