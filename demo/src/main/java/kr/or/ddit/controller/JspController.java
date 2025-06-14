package kr.or.ddit.controller;

import kr.or.ddit.service.BookService;
import kr.or.ddit.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/jsp")
@Slf4j
@Controller
public class JspController {
    // DI , IoC
    @Autowired
    BookService bookService;

    @GetMapping("/scripting")
    public String scripting() {
        return "jsp/scripting";
    }

    // 요청URI : /jsp/welcome
    // 웹 쇼핑몰 시작 페이지
    @GetMapping("/welcome")
    public String welcome() {
        // forwarding
        return "jsp/welcome";
    }
    // 요청 URI : /jsp/products
    // 상품목록 ( 데이터의 변경이 없음 -> Get 방식 사용)
    @GetMapping("/products")
    public String products(Model model) {

        List<ProductVO> productVOList = this.bookService.products();
        log.info("products -> productVOList: {}", productVOList);

        model.addAttribute("productVOList", productVOList);

        // forwarding: jsp 응답
        return "jsp/products";
    }
}
