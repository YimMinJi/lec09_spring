package com.gn.spring.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gn.spring.board.model.vo.Board;

@Controller
public class BoardApiController {
	private static final Logger LOGGER = LogManager.getLogger(BoardApiController.class);
	
	//만약 제이슨타입으로 요청을 보내면 컨트롤러도 응답받은 데이터를 제이슨으로 받아야해
	@ResponseBody
	@PostMapping("/board")
	public Map<String,String> createBoard(Board vo,
			@RequestParam("file") MultipartFile file){
		// Log4j2 실행해볼게 상단에 private static final Logger LOGGER 생성해줘
		LOGGER.info("Board 데이터 : "+vo);
		LOGGER.info("file 데이터 : " + file.getOriginalFilename());
		
		
		// 전달 어떻게 받을껀데요? 폼태그와 이름이 일치하면 그냥 객체를 써주면돼(createBoard(매개변수로))
		// 1. 파일을 저장(그래야 경로만 저장해도 끌고오지않겠니)
		// 2. 게시글 정보, 파일 정보 DB에 등록(Insert 할에정)
		// 3. 결과를 json 형태로 화면에 전달할거야 
		
		// 0802 : 10:32 가장먼저 json먼저할게 위에 1,2번은 오래걸린대
		Map<String,String> resultMap = new HashMap<String,String>();
		resultMap.put("res_code", "404");
		resultMap.put("res_msg", "게시글 등록중 오류가 발생하였습니다.");
		
		//화면단에 리턴해줄게 , 이거써주면 위에 빨간줄 사라진다. 0802 : 10:34
		return resultMap;
		
	}
}
