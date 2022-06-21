package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardService {
	// 글쓰기
	public void boardCreate(BoardVO vo);
	
	// 게시판 글 목록 조회
	public List<BoardVO> getBoardListAll();
}
