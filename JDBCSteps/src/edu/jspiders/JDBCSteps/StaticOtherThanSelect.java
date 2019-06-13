package edu.jspiders.JDBCSteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticOtherThanSelect
{
	public static void main(String[] args) 
	{
		try
		{
			//1.Loading the Drivers
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.Get the Connections
			String dburl = "jdbc:mysql://localhost:3306/hejm19_db?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);
			
			//3.issue the sql query
			String query = "insert into student values(4,'abc','xyz',89.69)";
			Statement stmt = con.createStatement();
			int count = stmt.executeUpdate(query);
			
			
			//4.Process the result
			if(count == 1)
			{
				System.out.println("Data Inserted Successfully");
			}
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			System.out.println("Data Not Inserted ");
			e.printStackTrace();
		}
	}
}
