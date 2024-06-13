package com.wsk0715.central.login.service;

import com.wsk0715.central.login.domain.Login;
import java.util.Map;

public interface LoginService {
	Map<String, String> requestLogin(Login login);

}
