package edu.jspiders.ServletChainingDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		//Dynamic resource
		//String url = "http://localhost:8081/ServletChainingDemo/s2";
		//static resource
		//String url = "http://localhost:8081/ServletChainingDemo/NewFile.html";
		
		String url = "https://www.gmail.com";
		resp.sendRedirect(url);
		PrintWriter out = resp.getWriter();
		
		out.println("<h1>This is a response of Servlet1</h1>");
	}
}
