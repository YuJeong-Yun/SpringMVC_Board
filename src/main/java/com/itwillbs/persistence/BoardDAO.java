package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardDAO {

	// 글쓰기
	public void create(BoardVO vo);
	
	// 글 리스트 (select - list)
	public List<BoardVO> listAll();
}
