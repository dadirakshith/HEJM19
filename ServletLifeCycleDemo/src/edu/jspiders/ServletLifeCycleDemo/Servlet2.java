package edu.jspiders.ServletLifeCycleDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
		
		out.print("<h1>This is a Servlet2 Response</h1>");
		
		ServletContext context = getServletContext();
		String nm = context.getInitParameter("Name");
		
		out.println("<h2>"+nm+"</h2>");
		
		ServletConfig config = getServletConfig();
		String plc = config.getInitParameter("place");
		out.println("<h2>"+plc+"</h2>");
	}
}
