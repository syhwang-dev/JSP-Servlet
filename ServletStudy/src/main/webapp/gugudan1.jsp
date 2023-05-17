<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String type = request.getParameter("type");
	String snum = request.getParameter("num");
	
	if (type == null) type = "list";
	else {
		if (!type.equals("table")) type = "list";
	}
	
	int num = 2;
	if (snum != null) num = Integer.parseInt(snum);
	if (num == 0) num = 2;
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 초장기 jsp 스타일이며, 현업에서는 사용하지 않는 스타일임. 알고만 넘어가기 -->
	<h2>구구단 타입1</h2>
<%-- 	<%
		for (int i=1; i<10; i++) {
	%>
		<%=num%> * <%=i%> = <%=num*i%><br> 
	<%
		}
	%> --%>
<% if (type.equals("table")) { %>
	<table>
		<tr><td><%= num %>단입니다.</td></tr>
		<% for (int i=1; i<=9; i++) { %>
			<tr><td><%= num %> * <%= i %> = <%= num * i %></td></tr>
		<% } %>
	</table>
<% } else { %>
	<h3><%= num %>단입니다.</h3>
	<ul>
	<% for (int i=1; i<=9; i++) { %>
		<li><%= num %> * <%= i %> = <%= num * i %></li>
	<% } %>
	</ul>
<% } %>	
	

</body>
</html>