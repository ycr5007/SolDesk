package com.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.dto.SpUser;
import com.study.dto.SpUserAuthority;
import com.study.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	// Spring Security 에서 제공하는 암호화
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@Transactional
	@Override
	public boolean register(SpUser user) {
		// 사용자가 입력한 비밀번호 암호화 ( 단방향 암호화 / 개발자가 비밀번호를 호출 할 수 없음 )
		user.setPassword(encoder.encode(user.getPassword()));
		
		boolean result = userMapper.register(user) > 0;
		userMapper.registerAuth(new SpUserAuthority(user.getUserid(), "ROLE_USER"));
		userMapper.registerAuth(new SpUserAuthority(user.getUserid(), "ROLE_ADMIN"));
		return result;
	}
}
