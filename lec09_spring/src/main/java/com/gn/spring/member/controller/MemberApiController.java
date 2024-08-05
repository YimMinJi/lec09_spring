package com.gn.spring.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gn.spring.member.model.vo.Member;


@Controller
public class MemberApiController {
	// 등록할때 json타입으로 보냇으니까 Map으로 리턴값 설정
//	@ResponseBody는 보내줄때 데이터값 , RequestBody는 요청받을때 데이터값
	@ResponseBody
	@PostMapping("/join")
	public Map<String,String> craeteMember(@RequestBody Member vo){
		
		System.out.println(vo);
		
		Map<String,String> resultMap = new HashMap<String,String>();
		resultMap.put("res_code", "404");
		resultMap.put("res_msg", "회원가입중 오류가 발생");
		
		
		
		
		
		
		
		return resultMap;
	}
}
