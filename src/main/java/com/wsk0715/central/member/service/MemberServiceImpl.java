package com.wsk0715.central.member.service;

import com.wsk0715.central.member.domain.Member;
import com.wsk0715.central.member.mapper.MemberMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	private final MemberMapper memberMapper;

	public MemberServiceImpl(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}


	@Override
	public List<Member> selectAll() {
		return memberMapper.selectAll();
	}

	@Override
	public Member select(String memberId) {
		return memberMapper.select(memberId);
	}

	@Override
	public boolean insert(Member member) {
		try {
			memberMapper.insert(member);
			return true;
		} catch (Exception ignored) {
			return false;
		}
	}

	@Override
	public boolean update(String memberId, Member member) {
		try {
			memberMapper.update(memberId, member);
			return true;
		} catch (Exception ignored) {
			return false;
		}
	}

	@Override
	public boolean delete(String memberId) {
		try {
			memberMapper.delete(memberId);
			return true;
		} catch (Exception ignored) {
			return false;
		}
	}

}
