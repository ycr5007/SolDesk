package com.study.dto;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class CustomUser extends User {
	
	private SpUser spUser;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		/*
			Collection<? extends GrantedAuthority> authorities :: SpUserAuthority 에 있는 값 중, authority 만 추출 하여 SimpleGrantedAuthority 를 통해 Collection 을 생성한다
		*/
		super(username, password, authorities);
	}

	public CustomUser(SpUser spUser) {
		super(spUser.getUserid(), spUser.getPassword(), spUser.getAuthorities().stream()
																			.map(auth -> new SimpleGrantedAuthority(auth.getAuthority()))
																			.collect(Collectors.toList()));
		this.spUser = spUser;
	}

	
	
}
