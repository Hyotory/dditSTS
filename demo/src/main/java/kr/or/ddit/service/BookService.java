package kr.or.ddit.service;

import kr.or.ddit.vo.BookVO;
import kr.or.ddit.vo.ProductVO;

import java.util.List;

public interface BookService {
    //insert/update/delete 시 return 타입은 int
    //BOOK 테이블에 도서를 등록
    public int createPost(BookVO bookVO);

    public BookVO detail(BookVO bookVO);

    public int deletePost(BookVO bookVO);

    public List<BookVO> list();

    public List<ProductVO> products();
}
