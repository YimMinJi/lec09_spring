package com.gn.spring.board.model.vo;

import java.util.Date;

import com.gn.spring.common.Paging;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 얘는 Bean이 아니야, 재사용하는게아니라구 계속 작동 로직이 바뀌어 --> 그래서 어노테이션안한다. 롬복한다.
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Board extends Paging{
	private int board_no;
	private String board_title;
	private String board_content;
	private Date reg_date;
	private int search_type = 1;
	private String search_text;
}
