<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	/* 내가 만든 에러 메시지 출력하기 */
	ArrayList<String> lists = (ArrayList<String>)session.getAttribute("lists");
	if (lists != null) {
		out.print("<h2>페이지 이동 후 session 영역의 속성 읽기</h2>");
		for (String str : lists)
			out.println(str + "<br/>");
	}
	else {
		out.print("<h1>Get out!</h1>");
	}
	
	// 두번째 방법 - try ch
/* 	try {
		ArrayList<String> lists = (ArrayList<String>)session.getAttribute("lists");
		for (String str : lists)
			out.println(str + "<br/>");
	} catch(Exception e) {
		
	} */

	
/* 	ArrayList<?> lists1 = (ArrayList<?>)session.getAttribute("lists");
	for (String str : lists1)
		if (str instanceof String)
		out.print(str + "<br/>");

	out.print("<br/>"); */
	
	
	
	
	%>

</body>
</html>