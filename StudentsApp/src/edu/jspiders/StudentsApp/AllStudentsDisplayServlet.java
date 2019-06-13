package edu.jspiders.StudentsApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllStudentsDisplayServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		PrintWriter out = resp.getWriter();
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/headder.html");
		dispatcher.include(req, resp);
		
		dispatcher = req.getRequestDispatcher("/welcome");
		dispatcher.include(req, resp);
		
		String query = "select * from student si,gaurdian_info gi,student_other_info soi where si.sid = gi.sid and si.sid = soi.sid";
		String url = "jdbc:mysql://localhost:3306/hejm19_db?user=root&password=root";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url);
			
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(query);
			
			String html1 = "<html>"
					+ "<head>"
					+ "<title>"
					+ "Success"
					+ "</title>"
					+ "</head>"
					+ "<body>"
					+ "<table border=2 align=center height=250px width=90% >"
					+ "<tr>"
					+ "<th>Regno</th>"
					+ "<th>First Name</th>"
					+ "<th>last Name</th>"
					+ "<th>Marks</th>"
					+ "<th>Guardian Name</th>"
					+ "<th>Relation</th>"
					+ "<th>gmail</th>"
					+ "</tr>";
					
			out.println(html1);
			while(rs.next())
			{
				 String html2 =
						 "<tr>"
				        + "<td>"+rs.getInt(1)+"</td>"
						+ "<td>"+rs.getString(2)+"</td>"
						+ "<td>"+rs.getString(3)+"</td>"
						+ "<td>"+rs.getDouble(4)+"</td>"
						+ "<td>"+rs.getString(6)+"</td>"
						+ "<td>"+rs.getString(7)+"</td>"
						+ "<td>"+rs.getString(9)+"</td>"
						+ "</tr>";
				 out.print(html2);
						
			}
			String html3 = "</table>"
							+ "</body>"
							+ "</html>";
			out.print(html3);
			dispatcher = context.getRequestDispatcher("/footer.html");
			dispatcher.include(req, resp);

			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(con != null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(stmt != null)
			{
				try 
				{
					stmt.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(rs != null)
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}
}
