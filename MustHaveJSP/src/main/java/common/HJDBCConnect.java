package common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.jsp.JspWriter;

public class HJDBCConnect {

	private String driver = "org.h2.Driver";
	private String url = "jdbc:h2:tcp://localhost/~/musthave";
	private String id = "musthave";
	private String pwd = "tiger";
	

	public HJDBCConnect() {}

	public HJDBCConnect(String driver, String url, String id, String pwd) {
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.pwd = pwd;
	}

	public Connection getConnection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, id, pwd);
	}

	public void writeMemberToTable(Connection con, JspWriter out) throws SQLException {
		Statement st = null; 
		ResultSet rs = null;
		
		try {
			out.write("<table border=\"1\" style=\"border:1px solid black;margin-left:auto;margin-right:auto;\">");
			out.write("<tr style=\"color: brown\">");
			out.write("<td>id</td><td>pass</td><td>name</td><td>regidate</td>");
			out.write("</tr>");
			
			st = con.createStatement();
			rs = st.executeQuery("select * from member");
			while(rs.next()) {
				out.write("<tr>");
				out.write("<td>"); out.write(rs.getString("id")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("pass")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("name")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("regidate")); out.write("</td>");
				out.write("</tr>");
			}
			out.write("</table>");
			out.write("<br/>");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (st != null) st.close();
			} catch (Exception e) {}
		}
	}
	
	public void writeBoardToTable(Connection con, JspWriter out) throws SQLException {
		Statement st = null; 
		ResultSet rs = null;
		
		try {
			out.write("<table border=\"1\" style=\"border:1px solid black;margin-left:auto;margin-right:auto;\">");
			out.write("<tr style=\"color: brown\">");
			out.write("<td>num</td><td>title</td><td>content</td><td>id</td><td>postdate</td><td>visitcount</td>");
			out.write("</tr>");
			
			st = con.createStatement();
			rs = st.executeQuery("select * from board");
			while(rs.next()) {
				out.write("<tr>");
				out.write("<td>"); out.write(rs.getString("num")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("title")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("content")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("id")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("postdate")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("visitcount")); out.write("</td>");
				out.write("</tr>");
			}
			out.write("</table>");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (st != null) st.close();
			} catch (Exception e) {}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		HJDBCConnect jdbc = new HJDBCConnect();
		Connection con = jdbc.getConnection();

		Statement st = null; 
		ResultSet rs = null;
		
		st = con.createStatement();
		rs = st.executeQuery("Select num, title, content, id, postdate, visitcount from board");
		
		while(rs.next() ) {
			System.out.println(String.format("%d, %s, %s, %s, %s, %d",
					rs.getInt("num"), rs.getString("title"), rs.getString("content"),
					rs.getString("id"), rs.getString("postdate"), rs.getInt("visitcount")
					));
		}
		
		con.close();
	}
}
