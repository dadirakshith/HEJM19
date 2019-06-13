package edu.jspiders.AttributesDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s1")
public class Servlet1 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession(true);
		Student student1 = new Student();
		
		student1.setId(1);
		student1.setName("Akashay");
		student1.setMarks(63.69);
		
		ServletContext context = getServletContext();
		
		context.setAttribute("myObj", student1);
		
		
		
		out.println("<h1>Attribute is setted</h1>");
	}
}
