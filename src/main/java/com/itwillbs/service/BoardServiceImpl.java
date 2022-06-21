package com.itwillbs.service;

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
		dao.create(vo);
	}

}
