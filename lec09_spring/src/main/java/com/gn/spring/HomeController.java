package com.gn.spring;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableAspectJAutoProxy
@Controller
public class HomeController {
	
	// 로그기록을 가져온다. 어떻게 가져와?
	
	
	// 클라이언트가 요청한 서비스 주소와 메소드를 연결해준다~
	// http://localhost:8090
	// http://localhost:8090/ 이 두개가 같다고 생각한다. 
	// 정확한 자바와, 유연한 브라우저 사이에서 둘다 같다라고 의미할때 저런식으로 쓴다.
	@RequestMapping(value= {"","/"},method=RequestMethod.GET)
	public String home() {
		// /WEB-INF/views/home.jsp로 이동해주세요랑 같은의미다.
		
		return "home";
	}
}
