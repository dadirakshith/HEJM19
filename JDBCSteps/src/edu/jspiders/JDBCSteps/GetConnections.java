package edu.jspiders.JDBCSteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnections
{
	public static void main(String[] args)
	{
		try
		{
			
			//1.Load the Drivers
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.Get the connections
			/*String dburl = "jdbc:mysql://localhost:3306/hejm19_db?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);*/
			
			String dburl = "jdbc:mysql://localhost:3306/hejm19_db";
			Connection con = DriverManager.getConnection(dburl,"root","root");
			
			if(con != null)
			{
				System.out.println("Connection Successful");
			}
		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			System.out.println("Connection not Successful");
			e.printStackTrace();
		}
	}
}
