package edu.jspiders.CookiesDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteCookies extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
		Cookie[] recivedCookies = req.getCookies();
		
		if(recivedCookies == null)
		{
			out.println("<h1>Cookies not Present</h1>");
		}
		else
		{
			for(Cookie c: recivedCookies)
			{
				if(Integer.parseInt(c.getValue())%2 == 0)
				{
					out.print("<h1>deleted cookie is "+c.getName()+"<h1>");
					c.setMaxAge(0);
					resp.addCookie(c);
				}
			}
		}
	}
}
