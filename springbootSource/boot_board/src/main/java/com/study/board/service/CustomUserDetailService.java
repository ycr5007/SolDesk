package com.study.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.study.board.dto.CustomUser;
import com.study.board.dto.MemberDTO;
import com.study.board.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("[UserDetailsService] <<<<< CustomUserDetailService >>>>> ");
		log.info("[UserDetailsService] User Id 정보 : " + username);
		// username = userid
		
		MemberDTO memberDto = mapper.read(username);
		log.info("[UserDetailsService] 인증 정보 : " + memberDto);
		
		return new CustomUser(memberDto);
	}
	
}
