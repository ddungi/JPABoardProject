package com.bank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class BankWebMvcConfiguration { 
	
	//로그인 실패 핸들러
	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler; 
	
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/", "/auth/**", "/js/**", "/image/**", "/webjars/**")
		.permitAll()
	
		// 위에서 언급한 경로 외에는 모두 인증을 거치도록 설정
		.and()	
		.authorizeRequests().anyRequest().authenticated()
	
		// 시큐리티가 제공하는 기본 로그인 화면은 CSRF 토큰을 무조건 전달
		// 하지만 사용자 정의 로그인 화면에서는 CSRF 토큰을 전달하지 않게 설정
		
		.and()
		.csrf().disable()
		// 사용자가 만든 로그인 화면 이용
		.formLogin().loginPage("/auth/login")
		//로그인 실패 핸들러 
		.failureHandler(authenticationFailureHandler)
	
		// 로그아웃 설정
		.and()
		.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/");

		return http.build();
			
	}

}
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//WebSecurityConfigurerAdapter 방식 (@Deprecated)
//@Override
//protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	auth.userDetailsService(userDetailsService);
//}

//@Override
//protected void configure(HttpSecurity http) throws Exception {
//	// 다음 경로에 대한 요청은 인증 없이 접근을 허용하도록 설정
//	http.authorizeRequests()
//		.antMatchers("/", "/auth/**", "/js/**", "/image/**", "/webjars/**")
//		.permitAll()
//	
//	// 위에서 언급한 경로 외에는 모두 인증을 거치도록 설정
//		.and()	
//		.authorizeRequests().anyRequest().authenticated()
//	
//	// 시큐리티가 제공하는 기본 로그인 화면은 CSRF 토큰을 무조건 전달
//	// 하지만 사용자 정의 로그인 화면에서는 CSRF 토큰을 전달하지 않게 설정.
//		.and()
//		.csrf().disable()
//	
//	// 사용자가 만든 로그인 화면 이용
//		.formLogin().loginPage("/auth/login")
//		.failureHandler(authenticationFailureHandler)
//	
//	// 로그아웃 설정
//		.and()
//		.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/");
