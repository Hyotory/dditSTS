package kr.or.ddit.mapper;

import kr.or.ddit.vo.BookVO;
import kr.or.ddit.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    // BOOK 테이블에 도서를 등록
    public int createPost(BookVO bookVO);

    // 도서 상세
    // BookVO [bookId=3, title=null, category=null, price=0, insertDate=null]
    public BookVO detail(BookVO bookVO);

    //도서 삭제
    //BookVO [bookId=3, title=총알탄 개똥이3, category=소설,
    //      price=2000, insertDate=null]
    public int deletePost(BookVO bookVO);

    public List<BookVO> list();

    public List<ProductVO> products();
}
