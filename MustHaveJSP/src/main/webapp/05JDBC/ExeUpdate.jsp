<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect3"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title></head>
<body>
	<h2>회원 추가 테스트(executeUpdate() 사용)</h2>
	<%
	JDBCConnect3 jdbc = new JDBCConnect3();
	// 추가
	Connection con = jdbc.getConnection();
	
	// con이 null이면?!
	if ( con == null ) {
		out.print("<h2>Fail to Connect DB</2>;");
		return;
	}
	
	// 이렇게 값을 고정되어 있는 것을 "하드코딩"이라고 함.
	String id = "test1";
	String pass = "1111";
	String name = "테스트1회원";
	
	// 이런 방법도 있다!
	// 웹 브라우저의 주소 뒤에 내용을 입력하면 됨.
	// 하지만 엉터리 방법 - 패스워드가 다 보임;
/* 	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	
	if (id == null) {
		out.print("<h2>Fail to Connect DB</2>;");
		return;
	} */
	
	String sql = "insert into member(id, pass, name) values (?, ?, ?)";
	PreparedStatement psmt = con.prepareStatement(sql);
	psmt.setString(1, id);
	psmt.setString(2, pass);
	psmt.setString(3, name);
	
	int intResult = psmt.executeUpdate();
	out.println(intResult + "행이 입력되었습니다.");
	
	psmt.close();
	// 확인 필요
	con.close();
	jdbc.closeConnection(con);
	%>

</body>
</html>