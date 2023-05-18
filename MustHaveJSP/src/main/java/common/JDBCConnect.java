package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnect {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	// 기본 생성자
	public JDBCConnect() {
		try {
			// JDBC 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/musthave";
			String id = "musthave";
			String pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB 연결 성공(기본 생성자)");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// static이 아니기 때문에 생성자를 만들어줘야 함.
		JDBCConnect jdbc = new JDBCConnect();
		System.out.println(jdbc);
		System.out.println(jdbc.con);
		
	}
	
	// 연결 해제(자원 반납)
	public void close() {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (psmt != null) psmt.close();
			if (con != null) con.close();
			
			System.out.println("JDBC 자원 해제");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
