package edu.jspiders.AttributesDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);
		
		if(session == null)
		{
			out.print("<h1>Already Logged out</h1>");
		}
		else
		{
			session.invalidate();
			out.print("<h1>Sucessfully Logged out</h1>");
		}
	}
}
