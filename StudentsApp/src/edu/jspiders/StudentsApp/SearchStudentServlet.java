package edu.jspiders.StudentsApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchStudentServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/headder.html");
		dispatcher.include(req, resp);
		
		dispatcher = context.getRequestDispatcher("/welcome");
		dispatcher.include(req, resp);
		
		resp.setContentType("text/html");
		String sregno = req.getParameter("regno");
		int regno = Integer.parseInt(sregno);
		
		
		//jdbc logic
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try 
		{
			//1.load the Drivers
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.get the connections
			String dburl = "jdbc:mysql://localhost:3306/hejm19_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			
			//3.issue the sql query
			String query = "select * from student where sid = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, regno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				String html = "<html>"
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
						+ "</tr>"
						+ "<tr>"
						+ "<td>"+rs.getInt(1)+"</td>"
						+ "<td>"+rs.getString(2)+"</td>"
						+ "<td>"+rs.getString(3)+"</td>"
						+ "<td>"+rs.getDouble(4)+"</td>"
						+ "</tr>"
						+ "</table>"
						+ "</body>"
						+ "</html>";
				out.print(html);
			}
			else
			{
				out.print("<h1> Student details not found  for "+regno+"</h1>");
			}
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
			if(pstmt != null)
			{
				try 
				{
					pstmt.close();
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
