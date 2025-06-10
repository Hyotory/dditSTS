<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! // 선언문(전역변수, 전역 메서드)
		int count = 3;

		// 전역 메서드
		String makeItLower(String data) {
			// 대문자 -> 소문자
			return data.toLowerCase();
		}

		// 전역 메서드
		// 리턴타입 매개변수들
		int sum(int a, int b){
			return a + b;
		}
	%>

	<% // 스크립틀릿(비지니스 로직)
		for(int i=1; i<=count; i++) {
			out.print("<p>개똥이" + i + "</p>");
		}

		out.print("<p>2 + 3 = " + sum(2,3) + "</p>");
	%>

	<!-- 표현문(변수 화면 출력)-->
	<%=makeItLower("Hello World")%>
	<p>2 + 3 = <%=sum(2,3)%></p>
</body>
</html>