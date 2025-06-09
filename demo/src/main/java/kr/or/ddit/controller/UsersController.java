package kr.or.ddit.controller;

import kr.or.ddit.service.LprodService;
import kr.or.ddit.service.UsersService;
import kr.or.ddit.util.ArticlePage;
import kr.or.ddit.vo.LprodVO;
import kr.or.ddit.vo.UsersVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Controller 어노테이션
스프링 프레임워크에게 "이 클래스는 웹 브라우저의 요청(request)를
받아들이는 컨트롤러야" 라고 알려주는 것임.
(regacy :스프링은 servlet-context.xml의 context:component-scan의 설정에 의해)-레거시
이 클래스를 자바빈 객체로 등록(메모리에 바인딩).

log.info : 썰
써ㄹ풀4람
*/
@RequestMapping("/users")
@Slf4j
@Controller
public class UsersController {
	// 서비스를 호출하기 위해 의존성 주입(Dependency Injection-DI)
	// IoC(Inversion of Control) -
	// 제어의 역전.
	// (개발자가 객체생성하지 않고 스프링이 객체를 미리 생성해놓은 것을 개발자가 요청)
	@Autowired
	UsersService usersService;

	/* action속성 및 값이 생략 시, 현재 URI(/list)를 재요청.
		method는 GET(form 태그의 기본 HTTP 메소드는 GET임)
		param : keyword=모험
		요청URI : /lprod/list?keyword=캐주얼&gubun=lprodNm or /lprod/list or /lprod/list?keyword=&gubun=
		요청파라미터 : keyword=모험
		요청방식 : get
	*/
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mav,
							 @RequestParam(value = "keyword",required = false, defaultValue = "" ) String keyword,
							 @RequestParam(value = "gubun",required = false, defaultValue = "" ) String gubun,
							 @RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage) {

		// content 구성
		List<UsersVO> usersVOList = this.usersService.list();
		log.info("list->usersVOList : " + usersVOList);

		// /list->keyword : 모험
		// /list->keyword :
		log.info("list->keyword : " + keyword);
		log.info("list->gubun : " + gubun);
		log.info("list->currentPage : " + currentPage);

		//맴(나) : 하 하 쏘맵
		//Map	: HashTable, HasMap, SortedMap
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("gubun", gubun);
		map.put("currentPage", currentPage);

		// total 구하기
		int total = this.usersService.getTotal(map);
		log.info("list->total: " + total);

		// 페이징 객체 생성
		ArticlePage<UsersVO> articlePage =
				new ArticlePage<UsersVO>(total, currentPage, 10, usersVOList, keyword);
		log.info("list->articlePage : " + articlePage);

		mav.addObject("articlePage", articlePage);
		mav.addObject("usersVOList", usersVOList);
		mav.setViewName("users/list");
		return mav;
	}
	
}
