<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<h2> 회원 목록 </h2>
<link rel="stylesheet" href="/AdminLTE/dist/css/adminlte.css" />
<script type="text/javascript" src="/AdminLTE/dist/js/adminlte.js"></script>
</head>
<body>


	<form>
		<select name="gubun">
			<option value="" selected>선택하세요</option>
			<option value="userName"
					<c:if test="${param.gubun == 'userName'}">selected</c:if>
			>권한</option>
			<option value="name"
					<c:if test="${param.gubun == 'name'}">selected</c:if>
			>회원명</option>
		</select>
		<input type="text" name="keyword" value="${param.keyword}"
			   placeholder="검색어를 입력해주세요"/>
		<!-- submit / button / reset -->
		<button type="submit" id="btsSearch">검색</button>
	</form>

	<!-- 시멘틱 -->
	<section class="content">
		<div class="container-fluid">
			<div class="row">
			<%--상품 분류 시작--%>
			<div class="col-md-12">
				<div class="card">
					<div class="card-header">
						<h3 class="card-title">Bordered Table</h3>
					</div>
					<!-- /.card-header -->
					<div class="card-body">
						<!-- mav.addObject("lprodVOList", lprodVOList); -->
						<table class="table table-bordered">
							<thead>
							<tr>
								<th style="width: 10%">번호</th>
								<th style="width: 20%">권한</th>
								<th style="width: 20%">이름</th>
								<th style="width: 25%">비밀번호</th>
								<th style="width: 25%">상태</th>
							</tr>
							</thead>
							<tbody>
								<!--
							   lprodVOList : List<LprodVO>

							   forEach태그? 배열(String[], int[][]), Collection(List, Set) 또는
										Map(HashTable, HashMap, SortedMap)

								var : 변수
								items : 아이템(배열, Collection, Map)
								varStatus : 루프 정보를 담은 객체 활용
									- index : 루프 실행 시 현재 인덱스(0부터 시작)
									- count : 실행 회수(1부터 시작. 보통 행번호 출력)
								-->
							<c:forEach var="user" items="${usersVOList}" varStatus="stat" >
								<tr>
									<td>${stat.count}</td>
									<td>${user.userName}</td>
									<td><a href="/lprod/detail?name=${user.name}">${user.name}</a></td>
									<td>${user.password}</td>
									<td>${user.enabled}</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
					${articlePage.pagingArea}
				</div>
			</div>
			<%--상품 분류 목록 끝--%>
			</div>
		</div>
	</section>

	<p>
		<a href="/users/create">회원 등록</a>
	</p>
</body>
</html>