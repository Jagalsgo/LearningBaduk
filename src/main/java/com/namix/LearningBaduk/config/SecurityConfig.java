package com.namix.LearningBaduk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/bootstrap/**", "/detail/detail").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/board/myOwnBoard", "/board/myWritingBoard", "/detail/**", "/user/editProfile").authenticated()
			.anyRequest().permitAll();
		http.formLogin()
            .loginPage("/user/login")
            .defaultSuccessUrl("/board/home")
            .loginProcessingUrl("/login")
            .permitAll();
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
}
