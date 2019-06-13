package edu.jspiders.AttributesDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s2")
public class Servlet2 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		PrintWriter out = resp.getWriter();
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/Logout.html");
		dispatcher.include(req, resp);
		HttpSession session = req.getSession(false);
		if(session == null)
		{
			out.print("<h1>Invalid Session</h1>");
		}
		else
		{
			
			
			Object recivedObj = context.getAttribute("myObj");
			
			if(recivedObj != null)
			{
				Student student1 = (Student) recivedObj;
				out.println("<h1>"+student1.getId()+"</h1>");
				out.println("<h1>"+student1.getName()+"</h1>");
				out.println("<h1>"+student1.getMarks()+"</h1>");
			}
			else
			{
				out.println("<h1>Attribute is not setted</h1>");
			}
		}
	}
}
