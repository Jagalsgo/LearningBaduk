package com.namix.LearningBaduk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.namix.LearningBaduk.service.SecurityUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	SecurityUserService securityUserService;
	
	@Bean //회원가입시 비번 암호화에 필요한 bean 등록
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}	
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) {
      //실제 인증을 진행할 Provider 
    }
	
	@Bean //실제 인증을 한 이후에 인증이 완료되면 Authentication객체를 반환을 위한 bean등록
	public DaoAuthenticationProvider authenticationProvider(SecurityUserService securityUserService) {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(securityUserService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	public void configure(WebSecurity web) throws Exception {
		// static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
		web.ignoring().antMatchers("/resource/**");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				/* .antMatchers("/css/**", "/js/**", "/img/**", "/bootstrap/**").permitAll() */
				.antMatchers("/admin/**").hasRole("admin")
				.antMatchers("/board/myOwnBoard", "/board/myWritingBoard", "/detail/updateDetail", "/detail/writeDetail", "user/editProfile").hasRole("user")
				.anyRequest().permitAll()
				.and()
			.formLogin()
				.loginPage("/user/login")
				.permitAll()
				.and()
			.logout()
				.invalidateHttpSession(true);
		
	}
	
}