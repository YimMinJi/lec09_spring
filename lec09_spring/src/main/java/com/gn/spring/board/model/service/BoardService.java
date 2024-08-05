package com.gn.spring.board.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gn.spring.board.model.dao.BoardDao;
import com.gn.spring.board.model.vo.Board;
// 비즈니스 로직을 처리하는 서비스다. Bean으로 설정해준거야
@Service
public class BoardService {
	
	
	@Autowired
	BoardDao boardDao; // 빈객체를 만들어주기만 하면된다. 
	
	// 이미지 업데이트중
	public int updateBoard(Board b) {
		int result = 0;
		try {
			result = boardDao.updateBoard(b);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	//이미지 등록 상세보기
	public Board selectBoardOne(int board_no) {
		Board result = null;
		try {
			result =boardDao.selectBoardOne(board_no);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	// 이미지 등록중
	public int insertBoard(Board vo) {
		int result = 0;
		try {
			result = boardDao.insertBoard(vo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 0801 게시판 목록 페이징
	// 전체목록 갯수를 조회 왜 ? 페이징해야해서 , 검색조건 추가할때 option 매개변수 넣고 값넣어줘
	public int selectBoardCount(Board option) {
		int result = 0;
		try {
			result = boardDao.selectBoardCount(option);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	// 0731 목록조회
	public List<Board> selectBoardList(Board option){
		List<Board> resultList = new ArrayList<Board>();
		try {
			resultList = boardDao.selectBoardList(option);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}
}
