package com.wsk0715.central.member.controller;

import com.wsk0715.central.member.domain.Member;
import com.wsk0715.central.member.service.MemberService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberApiController {
	private final MemberService memberService;

	public MemberApiController(MemberService memberService) {
		this.memberService = memberService;
	}


	@GetMapping("/")
	public Map<String, List<Member>> getAllMember() {
		List<Member> result = memberService.selectAll();
		Map<String, List<Member>> response = new HashMap<>(Map.of("result", result));

		return response;
	}

	@GetMapping("/{memberId}")
	public Map<String, Member> getMember(@PathVariable("memberId") String memberId) {
		Member result = memberService.select(memberId);
		Map<String, Member> response = new HashMap<>(Map.of("result", result));

		return response;
	}

	@PostMapping("/")
	public Map<String, Boolean> postMember(@RequestBody Member member) {
		boolean result = memberService.insert(member);
		Map<String, Boolean> response = new HashMap<>(Map.of("result", result));

		return response;
	}

	@PatchMapping("/{memberId}")
	public Map<String, Boolean> patchMember(@PathVariable("memberId") String memberId,
											@RequestBody Member member) {
		boolean result = memberService.update(memberId, member);
		Map<String, Boolean> response = new HashMap<>(Map.of("result", result));

		return response;
	}

	@DeleteMapping("/{memberId}")
	public Map<String, Boolean> deleteMember(@PathVariable("memberId") String memberId) {
		boolean result = memberService.delete(memberId);
		Map<String, Boolean> response = new HashMap<>(Map.of("result", result));

		return response;
	}

}
