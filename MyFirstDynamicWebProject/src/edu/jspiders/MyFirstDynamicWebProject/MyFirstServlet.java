package edu.jspiders.MyFirstDynamicWebProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		Date d = new Date();
		
		String curDate = d.toString();
		
		String html = "<!doctype HTML>"
				+ "<html>"
				+ "<head>"
				/*+ "<meta http-equiv=\"refresh\" content=\"5\">"*/
				+ "<title>"
				+ "Dynamic Resource"
				+ "</title>"
				+ "</head>"
				+ "<body>"
				+ "<h1>"
				+ curDate
				+ "</h1>"
				+ "</body>"
				+ "</html>";
		
		PrintWriter out = resp.getWriter();
		
		out.println(html);
		resp.setHeader("Refresh", "1");
	}
}
