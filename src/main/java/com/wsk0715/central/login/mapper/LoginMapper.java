package com.wsk0715.central.login.mapper;

import com.wsk0715.central.login.domain.Login;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
	Login getMemberByLoginId(String loginId);

}
