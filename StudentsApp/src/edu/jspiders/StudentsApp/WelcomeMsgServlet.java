package edu.jspiders.StudentsApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeMsgServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		PrintWriter out = resp.getWriter();
		int regNo = Integer.parseInt(req.getParameter("regno"));
		
		String query = "Select first_name,last_name from student where sid = ?";
		String dburl = "jdbc:mysql://localhost:3306/hejm19_db?user=root&password=root";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(dburl);
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, regNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				out.println("<h1 style=color:green>Welcome "+rs.getString(1)+" "+rs.getString(2)+"</h1>");
			}
			
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
