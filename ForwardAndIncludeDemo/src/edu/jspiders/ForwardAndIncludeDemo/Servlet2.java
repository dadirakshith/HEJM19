package edu.jspiders.ForwardAndIncludeDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s2")
public class Servlet2 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		PrintWriter out = resp.getWriter();
		
		out.print("<h1>This is a response of Servlet2</h1>");
		
		out.print("<h2>abcd</h2>");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("s3");
		dispatcher.include(req, resp);
		
		dispatcher = req.getRequestDispatcher("NewFile.html");
		dispatcher.include(req, resp);
		
	}
}
