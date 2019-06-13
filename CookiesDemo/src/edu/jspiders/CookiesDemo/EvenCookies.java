package edu.jspiders.CookiesDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/even")
public class EvenCookies extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
		Cookie[] recivedCookies = req.getCookies();
		
		if(recivedCookies == null)
		{
			out.print("<h1>Cookies not Present</h1>");
		}
		else
		{
			for(Cookie c : recivedCookies)
			{
				if(Integer.parseInt(c.getValue())%2 == 0)
				{
					out.println("<h1>name = "+c.getName()+"</h1>");
					out.println("<h1>value = "+c.getValue()+"</h1>");
				}
			}
		}
	}
}
