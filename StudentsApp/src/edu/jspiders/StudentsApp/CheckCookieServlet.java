package edu.jspiders.StudentsApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckCookieServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		PrintWriter out = resp.getWriter();
		Cookie[] recivedCookies = req.getCookies();
		if(recivedCookies == null)
		{
			out.print("<h1>Cookies not present</h1>");
		}
		else
		{
			for(Cookie c: recivedCookies)
				out.print("<h1>Cookies present is "+c.getName()+"</h1>");
		}
	}
}
