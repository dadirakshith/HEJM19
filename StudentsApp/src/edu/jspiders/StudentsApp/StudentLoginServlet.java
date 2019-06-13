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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentLoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		PrintWriter out = resp.getWriter();
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/headder.html");
		dispatcher.include(req, resp);
		
		dispatcher = context.getRequestDispatcher("/welcome");
		dispatcher.include(req, resp);
		
		int regNo = Integer.parseInt(req.getParameter("regno"));
		String pswd = req.getParameter("pswd");
		
		//add cookie
		Cookie regno = new Cookie("regno", req.getParameter("regno"));
		resp.addCookie(regno);
		
		
		String query = "select * from student si,gaurdian_info gi,student_other_info soi where si.sid = gi.sid and si.sid = soi.sid and soi.sid = ?	and soi.password = ?";
		String url = "jdbc:mysql://localhost:3306/hejm19_db?user=root&password=root";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url);
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, regNo);
			pstmt.setString(2, pswd);
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
						+ "<a href=allStudents>Click Here</a>"
						+ " to Display ALL STUDENTS"
						+ "<table border=2 align=center height=250px width=90% >"
						+ "<tr>"
						+ "<th>Regno</th>"
						+ "<th>First Name</th>"
						+ "<th>last Name</th>"
						+ "<th>Marks</th>"
						+ "<th>Guardian Name</th>"
						+ "<th>Relation</th>"
						+ "<th>gmail</th>"
						+ "</tr>"
						+ "<tr>"
						+ "<td>"+rs.getInt(1)+"</td>"
						+ "<td>"+rs.getString(2)+"</td>"
						+ "<td>"+rs.getString(3)+"</td>"
						+ "<td>"+rs.getDouble(4)+"</td>"
						+ "<td>"+rs.getString(6)+"</td>"
						+ "<td>"+rs.getString(7)+"</td>"
						+ "<td>"+rs.getString(9)+"</td>"
						+ "</tr>"
						+ "</table>"
						+ "</body>"
						+ "</html>";
				out.print(html);
			}
			else
			{
				out.println("<h1>Details not Present</h1> ");
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
