package com.namix.LearningBaduk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.namix.LearningBaduk.security.SecurityService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	SecurityService securityService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/bootstrap/**").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/board/myOwnBoard", "/board/myWritingBoard", "/detail/myOwnBoard", "/detail/updateDetail", "/detail/updateMyDetail", "/detail/writeDetail", "/detail/writeMyDetail", "/user/editProfile").authenticated()
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

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(securityService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
}
