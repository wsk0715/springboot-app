package com.wsk0715.central.login.service;

import com.wsk0715.central.login.domain.Login;
import com.wsk0715.central.login.mapper.LoginMapper;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
	private final LoginMapper loginMapper;

	public LoginServiceImpl(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}


	@Override
	public String requestLogin(Login login) {
		String loginId = login.getMemberId();
		String loginPw = login.getMemberPw();
		
		Login member = loginMapper.getMemberByLoginId(loginId);
		if (member == null) {
			return "FAILED_ID";
		}
		if (!loginPw.equals(member.getMemberPw())) {
			return "FAILED_PW";
		}
		return "SUCCESS";
	}

}
