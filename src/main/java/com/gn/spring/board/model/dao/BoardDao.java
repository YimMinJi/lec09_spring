package com.gn.spring.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gn.spring.board.model.vo.Board;

@Repository
public class BoardDao {
	//맵퍼에 넣을애를 주입시켜줘
	@Autowired
	SqlSession sqlSession;
	
	// 페이징중 , 검색조건 추가할때 option 매개변수 넣고 값넣어줘()
	public int selectBoardCount(Board option) {
		return sqlSession.selectOne("boardMapper.selectBoardCount", option);
	}
	
	public List<Board> selectBoardList(Board option){
		return sqlSession.selectList("boardMapper.selectBoardList",option);
	}

}
