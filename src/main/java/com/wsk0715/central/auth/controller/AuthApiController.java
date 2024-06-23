package com.wsk0715.central.auth.controller;

import com.wsk0715.central.auth.domain.Login;
import com.wsk0715.central.auth.service.AuthService;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthApiController {
	private final AuthService authService;

	public AuthApiController(AuthService authService) {
		this.authService = authService;
	}


	@PostMapping("/login")
	public Map<String, String> postRequestLogin(@RequestBody Login login) {
		Map<String, String> response = authService.requestLogin(login);

		return response;
	}

}
