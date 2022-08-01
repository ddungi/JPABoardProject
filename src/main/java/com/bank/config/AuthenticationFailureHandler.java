package com.bank.config;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		setDefaultFailureUrl("/auth/login?error=true&exception=" + errorMessage(exception));
		super.onAuthenticationFailure(request, response, exception);
	}
	
	private String errorMessage(AuthenticationException exception) {
		final Charset UTF8 = StandardCharsets.UTF_8;
		if (exception instanceof BadCredentialsException || exception instanceof InternalAuthenticationServiceException) {
			return URLEncoder.encode("아이디 또는 비밀번호가 맞지 않습니다. 다시 확인해 주세요.",UTF8);
		} 
		if (exception instanceof UsernameNotFoundException) {
			return URLEncoder.encode( "계정이 존재하지 않습니다. 회원가입 진행 후 로그인 해주세요.",UTF8);
		} 
		if (exception instanceof AuthenticationCredentialsNotFoundException) {
			return URLEncoder.encode("인증 요청이 거부되었습니다. 관리자에게 문의하세요.",UTF8);
		} 
		return URLEncoder.encode( "알 수 없는 이유로 로그인에 실패하였습니다 관리자에게 문의하세요.",UTF8);
		}
	}
