package edu.jspiders.MyFirstDynamicWebProject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestResponseDemo extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		PrintWriter out = resp.getWriter();
		
		out.println("<h1>Request Methods</h1>");
		StringBuffer url = req.getRequestURL();
		out.println("<h2> Url: "+url+"</h2>");
		String protocol = req.getProtocol();
		out.println("<h2> protocol: "+protocol+"</h2>");
		String method = req.getMethod();
		out.println("<h2> method: "+method+"</h2>");
		
		out.println("<h1>Response Methods</h1>");
		resp.setContentType("text/html");
		resp.sendError(900, "My own Error");
	}
}
