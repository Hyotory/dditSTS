package kr.or.ddit.mapper;

import kr.or.ddit.vo.UsersVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UsersMapper {
	//lprod 테이블에 도서를 등록
	public int createPost(UsersVO usersVO);
	
	//도서 상세
	//usersVO [lprodId=3, title=null, category=null, price=0, insertDate=null]
	public UsersVO detail(UsersVO usersVO);
	
	//도서 삭제
	//usersVO [lprodId=3, title=총알탄 개똥이3, category=소설, 
	//      price=2000, insertDate=null]
	public int deletePost(UsersVO UsersVO);
	
	//도서 목록
	public List<UsersVO> list();

	int getTotal(Map<String, Object> map);
}
