package com.wsk0715.central.login.controller;

import com.wsk0715.central.login.domain.Login;
import com.wsk0715.central.login.service.LoginService;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginApiController {
	private final LoginService loginService;

	public LoginApiController(LoginService loginService) {
		this.loginService = loginService;
	}


	@PostMapping("/login")
	public Map<String, String> postRequestLogin(@RequestBody Login login) {
		Map<String, String> response = loginService.requestLogin(login);

		return response;
	}

}
