package kr.or.ddit.vo;

import lombok.Data;

import java.util.List;

@Data
public class UsersVO {
	private String userName;
	private String name;
	private String password;
	private String enabled;
	// 관리자     권한           여러개일 수 있음
	// USERS : AUTHORITIES = 1 : N
	private List<AuthoritiesVO> authoritiesVOList;
}
