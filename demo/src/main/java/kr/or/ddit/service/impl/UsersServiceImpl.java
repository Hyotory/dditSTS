package kr.or.ddit.service.impl;

import kr.or.ddit.mapper.UsersMapper;
import kr.or.ddit.service.UsersService;
import kr.or.ddit.vo.UsersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//서비스 클래스 : 비즈니스 로직
//스프링 MVC 구조에서 Controller와 DAO를 연결하는 역할
/*
스프링 프레임워크는 개발자가 직접 클래스를 생성하는 것을 지양하고,
* 프링은 인터페이스를 좋아해. 자꾸자꾸 좋아지면 Impl은 어떡해
인터페이스를 통해 접근하는 것을 권장하고 있기 때문.(확장성)
그래서 서비스 레이어는 인터페이스(LprodService)와 클래스(LprodServiceImpl)를 함께 사용함

Impl : implement의 약자
*/
//"프링아 이 클래스 서비스 클래야"라고 알려주자. 프링이가 자바빈으로 등록해줌.
@Service
public class UsersServiceImpl implements UsersService {

	// SQL 실행을 위해 LprodMapper 인터페이스를 주입받자
	// DI(Dependency Injection):의존성 주입
	// IoC(Inversion of Control):제어의 역전

	@Autowired
	UsersMapper usersMapper;

	// insert/update/delete 시 return 타입은 int
	// BOOK 테이블에 도서를 등록
	@Override
	public int createPost(UsersVO usersVO) {
		return this.usersMapper.createPost(usersVO);
	}
	
	//도서상세
	@Override
	public UsersVO detail(UsersVO usersVO) {
		return this.usersMapper.detail(usersVO);
	}
	
	//도서삭제
	@Override
	public int deletePost(UsersVO usersVO) {
		return this.usersMapper.deletePost(usersVO);
	}

	@Override
	public List<UsersVO> list() {
		return this.usersMapper.list();
	}

	@Override
	public int getTotal(Map<String, Object> map) {
		return this.usersMapper.getTotal(map);
	}


}
