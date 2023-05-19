<%@page import="common.JDBCConnect2"%>
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
<h2 align="center">MustHave의 테이블 출력하기 출력하기</h2>

<%
{
	String driver = application.getInitParameter("MysqlDriver");
	String url = application.getInitParameter("MysqlURL");
	String id = application.getInitParameter("MysqlID");
	String pwd = application.getInitParameter("MysqlPwd");
	
	JDBCConnect2 jdbc = new JDBCConnect2(driver, url, id, pwd);
	Connection conn1 = jdbc.getConnection();
	jdbc.writeBoardToTable(conn1, out);
}
%>
<br>
<%
{
	String driver = application.getInitParameter("H2Driver");
	String url = application.getInitParameter("H2URL");
	String id = application.getInitParameter("H2ID");
	String pwd = application.getInitParameter("H2Pwd");
	
	HJDBCConnect jdbc2 = new HJDBCConnect(driver, url, id, pwd);
	Connection conn2 = jdbc2.getConnection();
	jdbc2.writeBoardToTable(conn2, out);
}
%>
 

</body>
</html>