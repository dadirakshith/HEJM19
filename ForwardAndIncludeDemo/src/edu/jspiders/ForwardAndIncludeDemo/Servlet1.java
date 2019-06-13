package edu.jspiders.ForwardAndIncludeDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s1")
public class Servlet1 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		//RequestDispatcher dispatcher = req.getRequestDispatcher("s2");
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/s2");
		dispatcher.forward(req, resp);
		
		PrintWriter out = resp.getWriter();
		
		out.print("<h1>This is a response of Servlet1</h1>");
	}
}
