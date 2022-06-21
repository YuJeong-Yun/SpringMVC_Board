package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String registerPOST(BoardVO vo, RedirectAttributes rttr) {
		log.info(" registerPOST() 호출 ");
		// 한글처리 (=> web.xml 필터로 처리)
		// 전달된 정보 저장(글쓰기 정보)
		log.info(" 글쓰기 정보 : " + vo);

		// 서비스 동작 호출
		service.boardCreate(vo);
		log.info(" 글쓰기 완료! ");
		// 정보를 전달
		rttr.addFlashAttribute("result", "REGOK");
		
		// return "/board/success";
		return "redirect:/board/listAll";
	}

	// http://localhost:8088/board/listAll
	// 글 리스트 - GET
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAllGET(Model model, @ModelAttribute("result") String result) {
		log.info(" listAllGET() 호출 ");

		log.info("결과 : " + result);

		// 디비에 저장되어 있는 모든 글정보를 가져와서
		List<BoardVO> boardList = service.getBoardListAll();

		// 연결된 뷰페이지에 출력
		model.addAttribute("boardList", boardList);
		model.addAttribute("result", result);
	}

	

}
