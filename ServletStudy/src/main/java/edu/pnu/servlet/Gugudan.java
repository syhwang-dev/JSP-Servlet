package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudan")
public class Gugudan extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		int num = 2;
//		int dan = Integer.parseInt(getServletInfo())
		String result = "";
		
		out.println("2단입니다.");
		
		out.println("<ul>");
		for (int i=1; i<10; i++) {
//			result += num + " * " + i + " = " + (num*i) + "<br/>";
			out.println("<li>");
			out.println(result = num + " * " + i + " = " + (num*i) + "<br/>");
			out.println("</li>");
		}
		
		
//		out.println("	<li>");
//		out.println(result);
//		out.println("	</li>");
		out.println("<ul>");
	}

}
