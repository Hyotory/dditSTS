package kr.or.ddit.service;

import kr.or.ddit.vo.UsersVO;

import java.util.List;
import java.util.Map;

public interface UsersService {

	// insert/update/delete 시 return 타입은 int
	// LPROD 테이블에 도서를 등록
	public int createPost(UsersVO usersVO);
	
	//상품 상세
	public UsersVO detail(UsersVO usersVO);
	
	//상품 삭제
	public int deletePost(UsersVO usersVO);
	
	//상품목록
	public List<UsersVO> list();

    int getTotal(Map<String, Object> map);
}
