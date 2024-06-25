package com.wsk0715.central.member.controller;

import com.wsk0715.central.member.domain.Member;
import com.wsk0715.central.member.service.MemberService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberApiController {
	private final MemberService memberService;


	@GetMapping
	public Map<String, List<Member>> getAllMember() {
		Map<String, List<Member>> response = new HashMap<>();

		try {
			List<Member> result = memberService.selectAll();
			response.put("result", result);
		} catch (Exception e) {
			System.err.println("Exception during getAllMember: " + e.getClass().getName());
			System.err.println(e.getCause().toString());
		}

		return response;
	}

	@GetMapping("/{memberId}")
	public Map<String, Member> getMember(@PathVariable("memberId") String memberId) {
		Map<String, Member> response = new HashMap<>();

		try {
			Member result = memberService.select(memberId);
			response.put("result", result);
		} catch (Exception e) {
			System.err.println("Exception during getMember: " + e.getClass().getName());
			System.err.println(e.getCause().toString());
		}

		return response;
	}

	@PostMapping
	public Map<String, Boolean> postMember(@RequestBody Member member) {
		Map<String, Boolean> response = new HashMap<>();

		try {
			boolean result = memberService.insert(member);
			response.put("result", result);
		} catch (Exception e) {
			System.err.println("Exception during postMember: " + e.getClass().getName());
			System.err.println(e.getCause().toString());
		}

		return response;
	}

	@PatchMapping("/{memberId}")
	public Map<String, Boolean> patchMember(@PathVariable("memberId") String memberId,
											@RequestBody Member member) {
		Map<String, Boolean> response = new HashMap<>();

		try {
			boolean result = memberService.update(memberId, member);
			response.put("result", result);
		} catch (Exception e) {
			System.err.println("Exception during patchMember: " + e.getClass().getName());
			System.err.println(e.getCause().toString());
		}

		return response;
	}

	@DeleteMapping("/{memberId}")
	public Map<String, Boolean> deleteMember(@PathVariable("memberId") String memberId) {
		Map<String, Boolean> response = new HashMap<>();

		try {
			boolean result = memberService.delete(memberId);
			response.put("result", result);
		} catch (Exception e) {
			System.err.println("Exception during deleteMember: " + e.getClass().getName());
			System.err.println(e.getCause().toString());
		}

		return response;
	}

}
