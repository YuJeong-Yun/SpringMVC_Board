package com.itwillbs.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	// 서비스 객체 주입
	@Inject
	private BoardService service;

	// 글쓰기 - GET
	// http://localhost:8088/board/register
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() {
		log.info(" registerGET() 호출 ");

	}

	// 글쓰기 - POST
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO vo) {
		log.info(" registerPOST() 호출 ");
		// 한글처리 (=> web.xml 필터로 처리)
		// 전달된 정보 저장(글쓰기 정보)
		log.info(" 글쓰기 정보 : " + vo);

		// 서비스 동작 호출
		service.boardCreate(vo);
		log.info(" 글쓰기 완료! ");

		// return "/board/success";
		return "redirect:/board/listAll";
	}

	// http://localhost:8088/board/listAll
	// 글 리스트 - GET
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAllGET() {
		log.info(" listAllGET() 호출 ");

	}

}
