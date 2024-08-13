package com.gn.spring.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gn.spring.member.domain.MemberDto;
import com.gn.spring.member.service.MemberService;

@Controller
public class MemberApiController {

	private final MemberService memberService;
	
	@Autowired
	public MemberApiController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@PostMapping("/join")
	@ResponseBody
	public Map<String,String> joinMember(@RequestBody MemberDto dto){
		Map<String,String> resultMap = new HashMap<String,String>();
		resultMap.put("res_code", "404");
		resultMap.put("res_msg", "회원가입 중 오류가 발생했습니다.");

		if(memberService.createMember(dto)>0) {
			resultMap.put("res_code", "200");
			resultMap.put("res_msg", "성공적으로 회원가입되었습니다.");
		};
		
		return resultMap;
	}
	
}
