package kr.or.ddit.mapper;

import kr.or.ddit.vo.BookVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    // BOOK 테이블에 도서를 등록
    public int createPost(BookVO bookVO);

    //도서 상세
    //BookVO [bookId=3, title=null, category=null, price=0, insertDate=null]
    public BookVO detail(BookVO bookVO);
}
