package edu.pnu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet01 extends HttpServlet {

	/**
	 * 
	 */
	
	// 1. Default Serial Version ID 추가 - 타이밍 하지 않고 MyServlet01에 마우스 대고 import add
	private static final long serialVersionUID = 1L;
	
	
	// 2. Control + space에서 method 추가
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws	ServletException, IOException {
		System.out.println("MyServlet01");
		
	}
}
