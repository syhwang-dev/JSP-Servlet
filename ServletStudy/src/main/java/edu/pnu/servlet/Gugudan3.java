package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudan3")
public class Gugudan3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		String type = req.getParameter("type");
		String snum = req.getParameter("snum");
		
		int num = 2;
		if (snum != null) num = Integer.parseInt(snum);
		try (PrintWriter out = resp.getWriter();) {
			if (type == null || type.equals("list")) {
				out.println("<h2>구구단 (servlet)</h2>");
				out.println("<ul>");
				for (int i=1; i<10; i++) {
					out.printf("<li>%d *%d = %d</li>", num, i, num*i);
				}
				out.println("</ul>");
			} else {
				out.println("<table border=\"1\" style=\"width:200px;\">");
				out.println("<tr><td>" + num + "단 입니다.</td></tr>");
				for(int i=1; i<=9; i++) {
					out.printf("<tr><td>%d * %d = %d</td></tr>\n", num, i, num*i);
				}
				out.println("</table>");
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
