package edu.jspiders.JDBCSteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicSelectType
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try 
		{
			//1.load the Drivers
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.Get Connections
			String dburl = "jdbc:mysql://localhost:3306/hejm19_db";
			System.out.println("Enter User name");
			String user = sc.next();
			System.out.println("Enter Password");
			String pswd = sc.next();
			
			con = DriverManager.getConnection(dburl, user, pswd);
			
			//3.issue the Sql Query
			String query = "select first_name last_name from student where sid = ?";
			
			pstmt = con.prepareStatement(query);
			System.out.println("Enter the id");
			int id = sc.nextInt();
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			//4.process the Result
			if(rs.next())
			{
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
			}
			else
			{
				System.out.println("Student not found with id "+ id);
			}
			
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			//5.Close All the JDBC Objects
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
