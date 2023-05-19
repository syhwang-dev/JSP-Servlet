<%@page import="java.sql.Connection"%>
<%@page import="common.HJDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">MustHave의 테이블 출력하기 출력하기 - H2 데이터베이스</h2>

<%
HJDBCConnect jdbc = new HJDBCConnect();
Connection conn = jdbc.getConnection();
jdbc.writeMemberToTable(conn, out);
%>
<br>
<%
String driver = application.getInitParameter("H2Driver");
String url = application.getInitParameter("H2URL");
String id = application.getInitParameter("H2ID");
String pwd = application.getInitParameter("H2Pwd");

HJDBCConnect jdbc2 = new HJDBCConnect(driver, url, id, pwd);
Connection conn2 = jdbc2.getConnection();
jdbc2.writeBoardToTable(conn2, out);
%>
 

</body>
</html>