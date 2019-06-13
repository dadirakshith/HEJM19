package edu.jspiders.StudentsApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateProfileServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		int regNo = Integer.parseInt(req.getParameter("regNo"));
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		double marks = Double.parseDouble(req.getParameter("marks"));
		
		String email = req.getParameter("mailId");
		String pswd = req.getParameter("pswd");
		
		String gname = req.getParameter("gname");
		String rel = req.getParameter("rel");
		
		String query1 = "insert into student values(?,?,?,?)";
		String query2 = "insert into student_other_info values(?,?,?)";
		String query3 = "insert into gaurdian_info values(?,?,?)";
		
		String url = "jdbc:mysql://localhost:3306/hejm19_db?user=root&password=root";
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		Connection con = null;
		
		PrintWriter out = resp.getWriter();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url);
			
			con.setAutoCommit(false);
			
			pstmt1 = con.prepareStatement(query1);
			pstmt1.setInt(1, regNo);
			pstmt1.setString(2, fname);
			pstmt1.setString(3, lname);
			pstmt1.setDouble(4, marks);
			
			int count1 = pstmt1.executeUpdate();
			
			pstmt2 = con.prepareStatement(query2);
			pstmt2.setInt(1, regNo);
			pstmt2.setString(2, email);
			pstmt2.setString(3, pswd);
			
			int count2 = pstmt2.executeUpdate();
			
			pstmt3 = con.prepareStatement(query3);
			pstmt3.setInt(1, regNo);
			pstmt3.setString(2, gname);
			pstmt3.setString(3, rel);
			
			int count3 = pstmt3.executeUpdate();
			
			con.commit();
			out.println("<h1>Registered Successfully</h1>");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			resp.sendError(100,"Not Registered");
			try
			{
				con.rollback();
			} 
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
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
			if(pstmt1 != null)
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
			if(pstmt2 != null)
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
			if(pstmt3 != null)
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
		}
	}
}
