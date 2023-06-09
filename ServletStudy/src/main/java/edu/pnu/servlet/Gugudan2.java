package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudan2")
public class Gugudan2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		String type = req.getParameter("type");
		String snum = req.getParameter("snum");
		
//		type.length() == null
		
		int num = 2;
		if (snum != null) num = Integer.parseInt(snum);
		try (PrintWriter out = resp.getWriter();) {
			out.println("<h2>구구단</h2>");
			
			String result = "";
			
			out.println(num+"단입니다.");
			out.println("<ul>");
			
			for (int i=1; i<10; i++) {
//				out.println("<li>result = num + ' * ' + i + ' = ' + (num*i) + '<br/>'<li>");
				out.println("<li>");
				out.println(result = num + " * " + i + " = " + (num*i) + "<br/>");
				out.println("</li>");
			}
			
			out.println("</ul>");
			
			out.println("<h2>Type은 " + type + "입니다.</h2>");
			
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
