<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("pAttr", "김유신");
request.setAttribute("rAttr", "계백");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>액션 태그를 이용한 포워딩</h2>
	<jsp:forward page="/07ActionTag/ForwardSub.jsp" />
	
	<!-- 위의 코드와 동일 -->
<%-- 	<%
	request.getRequestDispatcher("/07ActionTag/ForwardSub.jsp").forward(request, response);
	%> --%>
</body>
</html>