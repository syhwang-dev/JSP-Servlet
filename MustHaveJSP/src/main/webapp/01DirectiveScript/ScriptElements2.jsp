<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
public int add(int num1, int num2) {
	return num1 + num2;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int result = add(10, 20);

String n1 = request.getParameter("n1");
String n2 = request.getParameter("n2");
	
int result2 = add(Integer.parseInt(n1), Integer.parseInt(n2));
%>
덧셈 결과 1 : <%= result2 %> <br />
덧셈 결과 2 : <%= add(30, 40) %>


</body>
</html>