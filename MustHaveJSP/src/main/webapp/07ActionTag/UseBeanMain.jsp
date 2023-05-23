<%@page import="common.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title></head>
<body>
	<h2>useBean 액션 태그</h2>
	<h3>자바빈즈 생성하기</h3>
	<jsp:useBean id="person" class="common.Person" scope="request" />
	
	<h3>setProperty 액션 태그로 자바빈즈 속성 읽기</h3>
	<jsp:setProperty name="person" property="name" value="임꺽정" />
	<jsp:setProperty name="person" property="age" value="40" />
	<!-- L10 ~ 14: 스프링 프레임워크 문법만 비숫하고 복잡해져 나온 것이 스프링 부트 -->
	
	<h3>getProperty 액션 태그로 자바빈즈 속성 읽기</h3>
	<ul>
		<li>이름 : <jsp:getProperty property="name" name="person" /></li>
		<li>나이 : <jsp:getProperty property="age" name="person" /></li>
	</ul>

	<!-- 위의 액션 태그로 된 코드와 동일함. -->
	<%
		out.print("<h2>스크립틀릿으로 출력하기</h2>");
		Person p = new Person();
		p.setName("임꺽정");
		p.setAge(40);
		
		out.print(p.getName() + "<br>");
		out.print(p.getAge() + "<br>");
	%>

</body>
</html>