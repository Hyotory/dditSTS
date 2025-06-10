<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shopping mall</title>
<link rel="stylesheet" href="/css/bootstrap.min.css" />
<script src="/js/jquery.min.js"></script>
<script>

	function updateTime() {
		let today = new Date();
		let year = today.getFullYear();
		let month = ("0"+(today.getMonth() + 1)).slice(-2);
		let day = ("0"+(today.getDate())).slice(-2);
		let hour = today.getHours();
		let minute = today.getMinutes();
		let second = today.getSeconds();
		let todayStr = year + "-" + month + "-" + day + " ";
		todayStr += hour + ":" + minute + ":" + second;

		// <span id="spnCt"></span>
		const spnCt = document.getElementById("spnCt");
		spnCt.innerHTML = todayStr;
	}

	document.addEventListener("DOMContentLoaded", function() {
		// 1 초 단위로 함수 호출
		setInterval(updateTime, 1000);
	})
</script>
</head>
<body>
	<%@ include file="./menu.jsp" %>

	<%! // 선언문
		// 전역변수
		String greeting = "Welcome to Web Shopping Mall";
		String tagline = "Welcome to Web Market!";
	%>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3"><%=greeting%></h1>
		</div>
	</div>
	<div class="container">
		<div class="text-center">
			<h3><%=tagline%></h3>
			<span id="spnCt"></span>
			<%//스크립틀릿
				String am_pm = "AM";

				Date day = new Date();
				int hour = day.getHours();
				int minute = day.getMinutes();
				int second = day.getSeconds();

				if(hour / 12 == 0) {
					am_pm = "AM";
				} else {
					am_pm = "PM";
					hour -= 12;
				}

				String CT = hour+":"+minute+":"+second+":"+am_pm;
				out.print("<p> 현재 접속 시각 : " + CT + "</p>");
			%>
		</div>
	</div>

	<%@ include file="./footer.jsp" %>


</body>
</html>