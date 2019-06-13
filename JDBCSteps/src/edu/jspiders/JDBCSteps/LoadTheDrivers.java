package edu.jspiders.JDBCSteps;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class LoadTheDrivers
{
	public static void main(String[] args) 
	{
		/*//1.First Way
		try 
		{
			java.sql.Driver d = new Driver();
			DriverManager.registerDriver(d);
			
			System.out.println("Drivers Loaded susessfully");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}*/
		
		//2.Second Way
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Drivers Loaded susessfully");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
