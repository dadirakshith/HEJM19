package edu.jspiders.ServletLifeCycleDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet1 extends HttpServlet //GenericServlet
{
	public MyServlet1() 
	{
		System.out.println(this.getClass().getSimpleName()+" Object Created using no-args cnstr");
	}
	
	@Override
	public void init() throws ServletException 
	{
		System.out.println("In init Method");
	}
	/*@Override
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
		
		out.println("<h1>This is a Servlet1 Response</h1>");
		System.out.println("In Service Method");
	}*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		PrintWriter out = resp.getWriter();
		
		out.println("<h1>This is a Servlet1 Response</h1>");
		System.out.println("In doGet Method");
	}
	@Override
	public void destroy() 
	{
		System.out.println("In Destroy Method");
	}

}
