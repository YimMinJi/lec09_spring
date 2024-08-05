package com.gn.spring.board.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gn.spring.board.model.service.BoardService;
import com.gn.spring.board.model.vo.Board;
// 어노테이션 컨트롤러를 하면 이건 이제 서블릿처럼 쓸 수있어
@Controller
public class BoardViewController {
	@Autowired
	BoardService boardService; 
	// 이친구를 써서 주입시켜줬기에, 이친구 변수명을 그대로 가져가서 써준다.new 연산자 대신에
	
	// 0801 로깅을 써보겠다
	
//	@GetMapping("/board")
//	public ModelAndView selectBoardList() {
//		// 화면단에 데이터 보내는 방법, 두가지가있어
//		// 1. ModelAndView (두가지를 담아야해 객체, 데이터도 담고, 화면도 담고)
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("resultList", resultList);
//		// 화면단도 세팅해줘, 리턴에 적은거 고대로 써줘
//		mav.setViewName("/board/list");
//		return mav;
//}
		

	//게시판 목록
	@GetMapping("/board")
//		리턴값은 String이야
	// 0801 매개변수로 Board option넣어줬어 왜? 페이징 해야해서
	public String selectBoardList(Model model, Board option) {
		//08 01 
		option.setTotalData(boardService.selectBoardCount(option));
		// 검색조건을 추가해줘야지(그냥 냅둬도 된대), 페이징바랑 전체데이터 갯수는 각각 따로 검색조건이필요 
		// option.setTotalData(보드서비스.셀렉보드카운트(옵션[이거추가해준거]))
		
		
		// List<Board>꺼내올게 ==> 이제 new 연산자 안한대
		List<Board> resultList = boardService.selectBoardList(option);
		// 0801 로깅 추가 / 콘솔창 대신에 로깅설정
//		LOGGER.info(resultList);
		// 2. Model --> 매개변수로 모델을 써준다. (매개변수 꼭 설정하기, 어트리뷰트 안에 <키 벨류값으로> )
		model.addAttribute("resultList",resultList);
		// 0801 페이징 추가, 옵션추가 (한바퀴 순회하고 와서 설정해줘야해)
		model.addAttribute("paging", option);

//		/WEB-INF/views/board/list.jsp
		return "/board/list";
		
	}
	// 등록화면 0802
	@GetMapping("/board/create")
	public String createBoardPate() {
		// 위 url이랑 밑 url은 다른거야 
		// /WEB-INF/views/board/create.jsp
		return "/board/create";
	}
	// 상세화면 0802
	@GetMapping("/board/{board_no}")
	public String selectBoardOne(@PathVariable("board_no") int board_no, Model model) {
		// 위에 PathVarible(괄호안에는 위에 {중괄호안에 값}을 넣고 정규식패턴느낌이라 생각하면됌)
		
		// WEB-INF/views/board/detail.jsp
		
		
//		Board객체안에 board_no의 값을 넣어서 보내주기
		Board b = boardService.selectBoardOne(board_no);
		// 모델앤뷰를 쓰거나, 모델방식을 쓰거나
		model.addAttribute("b",b); // 키값이 b라는 이름으로 전달한다.
		
		return "/board/detail";

		}
	// 이미지 게시글 수정 
	@GetMapping("/board/update/{board_no}")
	public String updateBoard(@PathVariable("board_no") int board_no, Model model) {
		Board b = boardService.selectBoardOne(board_no);
		model.addAttribute("b",b);
		
		return "/board/update";
	}
}
