<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 - request</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %> <!-- POST 방식으로 전송 시 한글이 깨지는 부분 고치기 - UTF-8로 다시 인코딩 -->
	<!-- 코드 블럭은 자바처럼 만들어줘야하므로 세미콜론 필요 -->
	<h2>1. 클라이언트와 서버의 환경정보 읽기</h2>
	<ul>
		<li>데이터 전송 방식: <%= request.getMethod() %></li>
		<li>URL: <%= request.getRequestURL() %></li>
		<li>URI: <%= request.getRequestURI() %></li>
		<li>프로토콜: <%= request.getProtocol() %></li>
		<li>서버명: <%= request.getServerName() %></li>
		<li>서버 포트: <%= request.getServerPort() %></li>
		<li>클라이언트 IP 주소: <%= request.getRemoteAddr() %></li>
		<li>쿼리스트링: <%= request.getQueryString() %></li>
		<li>전송된 값 1: <%= request.getParameter("eng") %></li>
		<li>전송된 값 2: <%= request.getParameter("han") %></li>
	</ul>
	<!-- ul태그 밑에 있는 표현식으로 나타나는 데이터에는 세미콜론을 사용하지 않음. -->
	<!-- 왜? 표현식은 out.write(request.getMethod()) 안에 들어가게 되는데 세미콜론도 함께 들어가면 에러 발생 / getMethod()-->
</body>
</html>