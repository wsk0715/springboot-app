package com.wsk0715.central.login.service;

import com.wsk0715.central.login.domain.Login;
import com.wsk0715.central.login.mapper.LoginMapper;
import com.wsk0715.central.utils.jwt.JwtUtil;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
	private final LoginMapper loginMapper;

	public LoginServiceImpl(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}


	@Override
	public Map<String, String> requestLogin(Login login) {
		String loginId = login.getMemberId();
		String loginPw = login.getMemberPw();

		Map<String, String> result = new HashMap<>(
				Map.of("result", "FAILED_ID")
		);
		Login member = loginMapper.getMemberByLoginId(loginId);
		if (member != null) {
			result.replace("result", "FAILED_PW");
			if (loginPw.equals(member.getMemberPw())) {
				result.replace("result", "SUCCESS");
				result.put("token", JwtUtil.generateToken(loginId));
			}
		}
		return result;
	}

}
