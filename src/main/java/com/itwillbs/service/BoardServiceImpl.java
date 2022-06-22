package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	// DAO 객체 주입
	@Inject
	private BoardDAO dao;
	
	
	@Override
	public void boardCreate(BoardVO vo) {
		log.info(" boardCreate(BoardVO vo) 호출 ");
		dao.create(vo);
	}


	@Override
	public List<BoardVO> getBoardListAll() {
		log.info(" getBoardListAll() 호출 ");
		
		return dao.listAll();
	}


	@Override
	public BoardVO readBoard(Integer bno) {
		log.info(" readBoard(Integer bno) 호출 ");
		
		return dao.getBoard(bno);
	}


	@Override
	public void updateBoard(BoardVO vo) {
		log.info(" updateBoard(BoardVO vo) 호출");
		
		dao.updateBoard(vo);
	}


	@Override
	public void deleteBoard(Integer bno) {
		log.info(" deleteBoard(int bno) 호출");
		
		dao.removeBoard(bno);
	}

}
