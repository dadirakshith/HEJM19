package edu.jspiders.MyFirstJDBCApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyFirstOperation 
{
	public static void main(String[] args)
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{
			//1.load the Drivers
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.Get the Connections
			String dburl = "jdbc:mysql://localhost:3306/hejm19_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			
			//3.issue the sql query
			String query = "select * from student";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			//4.process the result
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getDouble(4));
				System.out.println("------------------");
			}
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			//5. Close the jdbc objects
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
