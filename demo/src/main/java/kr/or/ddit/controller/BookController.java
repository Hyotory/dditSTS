package kr.or.ddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/*
Controller 어노테이션
스프링 프레임워크에게 "이 클래스는 웹 브라우저의 요청(request)를
받아들이는 컨트롤러야" 라고 알려주는 것임.
스프링은 servlet-context.xml의 context:component-scan의 설정에 의해
이 클래스를 자바빈 객체로 등록(메모리에 바인딩).

log.info : 썰
써ㄹ풀4람
*/

@Slf4j
@Controller
public class BookController {
    //책 입력 화면
   /*
    요청URI : /create
    요청파라미터 : 없음
    요청방식 : get
    */
    //RequesetMapping 어노테이션 : 웹 브라우저의 요청에 실행되는 자바 메소드 지정
   /*
   method 속성은 http 요청 메소드를 의미함. 일반적인 웹 페이지 개발에서 GEt 메소드는
   데이터를 변경하지 않는 경우에, POST 메소드는 데이터가 변경될 경우 사용
   책 생성 화면은 웹 브라우저에 화면을 보여줄 뿐 데이터의 변경이 일어나지 않으므로
      GET 메소드를 사용함
    */
    @RequestMapping(value="/create",method=RequestMethod.GET)
    public ModelAndView create() {
        /*
       ModelAndView
       1) Model : Controller가 반환할 데이터(String, int, List, Map, VO..)를 담당
       2) View : 화면을 담당(뷰(View : JSP)의 경로)
       */
        ModelAndView mav = new ModelAndView();

        // prefix(접두어) : /WEB-INF/views/
        // suffix(접미어) : .jsp
        // /WEB-INF/views/ + book/create + .jsp
        //forwarding
        mav.setViewName("book/create");
        return mav;
    }
    
    /* 
    요청URI : /createPost
    요청파라미터 : {title=총알탄 개똥이, category=소설, price=10000}
    요청방식 : post
    
    스프링에서 파라미터의 명과 매개변수 명이 같으면 파라미터 값이 매개변수 값으로 할당됨
    모든 파라미터는 문자. 그래서 price의 값이 "12000"도 숫자형 문자임
    */
    @RequestMapping(value="/createPost", method=RequestMethod.POST)
    public ModelAndView createPost(String title, String category, String price) {
    	
    	log.info("title : " + title);
    	log.info("category : " + category);
    	log.info("price : " + price);
    	
    	return null;
    }
}
