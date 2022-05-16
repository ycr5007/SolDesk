package com.study.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	// 로그인 성공 후 기본으로 동작하는 핸들러 대신 개발자가 원하는 곳으로 이동 가능
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("[Handler] <<<<< Login Success Handler >>>>>");
		
		// 부여된 권한 확인하기
		List<String> roleNames = new ArrayList<String>();
		authentication.getAuthorities().forEach(auth -> roleNames.add(auth.getAuthority()));
		
		log.info("[Handler] RoleNames : " + roleNames);
		
		if(roleNames.contains("ROLE_ADMIN")) {
			// 권한이 "ROLE_ADMIN" 이라면 admin-page 이동
			response.sendRedirect("/member/admin-page");
			return;
		}else if(roleNames.contains("ROLE_MEMBER") || roleNames.contains("ROLE_MANAGER")){
			// 권한이 "ROLE_MEMBER" / "ROLE_MANAGER" 라면 /board/list Controller 이동
			response.sendRedirect("/board/list");
			return;
		}
		// 권한이 없는 경우
		response.sendRedirect("/");
	}
	
}
