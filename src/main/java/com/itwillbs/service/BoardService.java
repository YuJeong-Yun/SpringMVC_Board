package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.PageMaker;

public interface BoardService {
	// 글쓰기
	public void boardCreate(BoardVO vo);
	
	// 게시판 글 목록 조회
	public List<BoardVO> getBoardListAll();
	
	// 글정보 가져오기
	public BoardVO readBoard(Integer bno);
	
	// 글 수정하기
	public void updateBoard(BoardVO vo);
	
	// 글 삭제하기
	public void deleteBoard(Integer bno);
	
	// 글 조회수 증가
	public void increaseViewCnt(Integer bno);
	
	// 페이징 처리
	public List<BoardVO> boardListCri(PageMaker pm);
	
	// 글 전체 개수 조회
	public Integer totalCnt();
}
