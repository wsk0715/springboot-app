package com.wsk0715.central.member.service;

import com.wsk0715.central.member.domain.Member;
import java.util.List;

public interface MemberService {
	List<Member> selectAll();

	Member select(String memberId);

	boolean insert(Member member);

	boolean update(String memberId, Member member);

	boolean delete(String memberId);

}
