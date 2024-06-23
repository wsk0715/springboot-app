package com.wsk0715.central.auth.service;

import com.wsk0715.central.auth.domain.Login;
import com.wsk0715.central.auth.mapper.AuthMapper;
import com.wsk0715.central.utils.jwt.JwtUtil;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
	private final AuthMapper authMapper;

	public AuthServiceImpl(AuthMapper authMapper) {
		this.authMapper = authMapper;
	}


	@Override
	public Map<String, String> requestLogin(Login login) {
		String loginId = login.getMemberId();
		String loginPw = login.getMemberPw();

		Map<String, String> result = new HashMap<>(
				Map.of("result", "FAILED_ID")
		);
		Login member = authMapper.getMemberByLoginId(loginId);
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
