package com.wsk0715.central.member.mapper;

import com.wsk0715.central.member.domain.Member;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {
	List<Member> selectAll();

	Member select(String memberId);

	void insert(Member member);

	void update(@Param("memberId") String memberId,
				@Param("member") Member member);

	void delete(String memberId);

}
