package com.wsk0715.central.auth.service;

import com.wsk0715.central.auth.domain.Login;
import java.util.Map;

public interface AuthService {
	Map<String, String> requestLogin(Login login);

}
