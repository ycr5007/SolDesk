package com.study.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.study.handler.CustomAccessDeniedHandler;
import com.study.handler.CustomLoginSuccessHandler;
import com.study.service.CustomUserDetailService;

@EnableWebSecurity // Spring-MVC + security 결합 
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	public SecurityConfig(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}


	@Bean
	// <bean id="encoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder" />
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	// <bean id="customLoginSuccessHandler" class="com.study.handler.CustomLoginSuccessHandler" />
	public AuthenticationSuccessHandler customLoginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	@Bean
	// <bean id="customAccessDeniedHandler" class="com.study.handler.CustomAccessDeniedHandler" />
	public AccessDeniedHandler customAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	@Bean
	// <bean id="customUserDetailService" class="com.study.service.CustomUserDetailService" />
	public UserDetailsService customUserDetailService() {
		return new CustomUserDetailService();
	}
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		return repo;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailService())
			.passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		http.addFilterBefore(filter, CsrfFilter.class);
		
		http.formLogin()
			.loginPage("/member/login")
			.loginProcessingUrl("/login")
			.successHandler(customLoginSuccessHandler())
			.failureUrl("/member/login-error");
		
		http.logout()
			.logoutUrl("/member/logout")
			.invalidateHttpSession(true)
			.logoutSuccessUrl("/board/list");
		
		http.rememberMe()
			.tokenRepository(persistentTokenRepository())
			.tokenValiditySeconds(604800);
		
	}
}
