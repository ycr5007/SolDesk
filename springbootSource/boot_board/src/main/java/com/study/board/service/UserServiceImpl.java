package com.study.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.board.dto.MemberDTO;
import com.study.board.mapper.MemberMapper;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private MemberMapper userMapper;
	
	// Spring Security 에서 제공하는 암호화
	@Autowired
	private PasswordEncoder encoder;
	
	
	@Transactional
	@Override
	public boolean register(MemberDTO member) {
		// 사용자가 입력한 비밀번호 암호화 ( 단방향 암호화 / 개발자가 비밀번호를 호출 할 수 없음 )
//		member.setUserpw(encoder.encode(member.getUserpw()));
//		
//		boolean result = userMapper.register(member) > 0;
//		userMapper.registerAuth(new AuthDTO(member.getUserid(), "ROLE_USER"));
//		userMapper.registerAuth(new AuthDTO(member.getUserid(), "ROLE_ADMIN"));
//		return result;
		return false;
	}
}
