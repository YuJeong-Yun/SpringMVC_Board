package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	// 디비연결 및 mapper 연결처리 객체
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.itwillbs.mapper.BoardMapper";
	
	@Override
	public void create(BoardVO vo) {
		log.info("정보 전달받아서 mapper 호출");
		// 정보 전달받아서 mapper를 거쳐서 DB에 저장
		sqlSession.insert(NAMESPACE+".createBoard", vo);
		
		log.info("mapper에서 처리 후 이동 ");
	}

	@Override
	public List<BoardVO> listAll() {
		log.info(" listAll() 호출");
		
		// mapper 해당 sql 호출
		return sqlSession.selectList(NAMESPACE+".listAll");
	}

	@Override
	public BoardVO getBoard(Integer bno) {
		log.info(" getBoard() 호출 ");
		
		return sqlSession.selectOne(NAMESPACE+".getBoard", bno);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		
		sqlSession.update(NAMESPACE+".updateBoard", vo);
	}
	

}
