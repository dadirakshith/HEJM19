package edu.jspiders.MyFirstDynamicWebProject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QueryStringDemoServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		String fnm = req.getParameter("fname");
		String lnm = req.getParameter("lname");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<h1> Welcome "+fnm+" "+lnm+"</h1>");
	}
}
