<%@page import="java.sql.Connection"%>
<%@page import="common.JDBCConnect2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">MustHave의 테이블 출력하기 출력하기 - MySQL 데이터베이스</h2>
<%-- <%
	JDBCConnect2 jdbc = new JDBCConnect2();
	Connection conn = jdbc.getConnection();
	
	jdbc.writeMemberToTable(conn, out);
	jdbc.writeBoardToTable(conn, out);
	
	// 차이 - 보안 문제
	// + 수정을 하게 되면 jsp 파일마다 다... 수정해야 함.
	JDBCConnect2 jdbc2 = new JDBCConnect2(
			"com.mysql.cj.jdbc.Driver",
			"jdbc:mysql://localhost:3306/musthave",
			"musthave",
			"tiger");
	
	// 186P. 책에서 추천하는 방법
	// 어플리케이션 객체: 톰캣 객체 그 자체를 의미
%> --%>

<!-- 유지보수하는데 유리한 코드 -->
<%
JDBCConnect2 jdbc = new JDBCConnect2();
Connection conn = jdbc.getConnection();
jdbc.writeMemberToTable(conn, out);
%>
<br>
<%
String driver = application.getInitParameter("MysqlDriver");
String url = application.getInitParameter("MysqlURL");
String id = application.getInitParameter("MysqlID");
String pwd = application.getInitParameter("MysqlPwd");

JDBCConnect2 jdbc1 = new JDBCConnect2(driver, url, id, pwd);
Connection conn1 = jdbc.getConnection();
jdbc.writeBoardToTable(conn1, out);
%>
 

</body>
</html>