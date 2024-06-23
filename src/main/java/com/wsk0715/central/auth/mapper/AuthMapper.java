package com.wsk0715.central.auth.mapper;

import com.wsk0715.central.auth.domain.Login;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {
	Login getMemberByLoginId(String loginId);

	int checkIdDuplicated(String checkId);

}
