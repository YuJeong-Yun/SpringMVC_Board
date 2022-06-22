package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardDAO {

	// 글쓰기
	public void create(BoardVO vo);
	
	// 글 리스트 (select - list)
	public List<BoardVO> listAll();
	
	// 글정보 가져오기
	public BoardVO getBoard(Integer bno);
	
	// 글 수정
	public void updateBoard(BoardVO vo);
	
	// 글 삭제
	public void removeBoard(Integer bno);
	
	// 글 조회수 증가
	public void increaseViewCnt(Integer bno);
}
