// 8장. 모델1 방식의 회원제 게시판 만들기
package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;

public class JDBCConnect {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	String url;
	String id;
	String pwd;
	
	// 기본 생성자
	public JDBCConnect() {
		try {
			// JDBC 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			url = "jdbc:mysql://localhost:3306/musthave";
			id = "musthave";
			pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB 연결 성공(기본 생성자)");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// application을 사용하는 생성자
    public JDBCConnect(ServletContext application) {
        try {
            // JDBC 드라이버 로드
            String driver = application.getInitParameter("MysqlDriver"); 
            Class.forName(driver); 

            // DB에 연결
            url = application.getInitParameter("MysqlURL"); 
            id = application.getInitParameter("MysqlID");
            pwd = application.getInitParameter("MysqlPwd");
            con = DriverManager.getConnection(url, id, pwd);

            System.out.println("DB 연결 성공(application을 사용하는 생성자)"); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		// static이 아니기 때문에 생성자를 만들어줘야 함.
		JDBCConnect jdbc = new JDBCConnect();
		System.out.println(jdbc.con);
		System.out.println("URL: " + jdbc.url);
		System.out.println("ID: " + jdbc.id);
		System.out.println("Password: " + jdbc.pwd);
		System.out.println();
		
		Connection con = null;
		Statement st = null; 
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/musthave", jdbc.id, jdbc.pwd);
			
			st = con.createStatement();
			rs = st.executeQuery("Select num, title, content, id, postdate, visitcount from board");
			
			while(rs.next() ) {
				System.out.println(String.format("%d, %s, %s, %s, %s, %d",
						rs.getInt("num"), rs.getString("title"), rs.getString("content"),
						rs.getString("id"), rs.getString("postdate"), rs.getInt("visitcount")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (st != null) st.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//		con.close();  에러 발생 이유: 위에 닫는 코드가 있음.
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
