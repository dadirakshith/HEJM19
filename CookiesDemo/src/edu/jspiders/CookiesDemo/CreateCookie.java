package edu.jspiders.CookiesDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class CreateCookie extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		Cookie cookie1 = new Cookie("c1", "100");
		Cookie cookie2 = new Cookie("c2", "201");
		Cookie cookie3 = new Cookie("c3", "300");
		Cookie cookie4 = new Cookie("c4", "403");
		Cookie cookie5 = new Cookie("c5", "500");
		
		
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
		resp.addCookie(cookie3);
		resp.addCookie(cookie4);
		resp.addCookie(cookie5);
		
		PrintWriter out = resp.getWriter();
		
		out.println("<h1>Cookies Created</h1>");
	}
}
