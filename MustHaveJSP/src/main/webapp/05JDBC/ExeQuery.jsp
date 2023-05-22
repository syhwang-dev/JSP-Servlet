<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="common.JDBCConnect3"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title></head>
<body>
	<h2>회원 목록 조회 테스트(executeQuery() 사용)</h2>
	<%
	JDBCConnect3 jdbc = new JDBCConnect3();
	// 추가
	Connection con = jdbc.getConnection();
	
	// con이 null이면?!
	if ( con == null ) {
		out.print("<h2>Fail to Connect DB</2>;");
		return;
	}
	
	String sql = "select id, pass, name, regidate from member";
	Statement stmt = con.createStatement();
	
	ResultSet rs = stmt.executeQuery(sql);
	
	// 결과 확인
	while (rs.next()) {
		String id = rs.getString(1);
		String pass = rs.getString(2);
		String name = rs.getString("name");
		java.sql.Date regidate = rs.getDate("regidate");
		
		out.println(String.format("%s %s %s %s", id, pass, name, regidate) + "<br/>");
	}
	
	rs.close();
	stmt.close();
	%>

</body>
</html>