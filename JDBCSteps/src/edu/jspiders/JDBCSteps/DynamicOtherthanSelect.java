package edu.jspiders.JDBCSteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicOtherthanSelect 
{
	public static void main(String[] args)
	{
		//Scanner sc = new Scanner(System.in);
		String sid = args[0];
		String fname = args[1];
		String lname = args[2];
		String smarks = args[3];
		int id = Integer.parseInt(sid);
		double marks = Double.parseDouble(smarks);
		try 
		{
			//1.Load the Drivers
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.get the Connections
			String dburl = "jdbc:mysql://localhost:3306/hejm19_db?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);
			
			//3.issue the sql query
			String query = "insert into student values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			/*System.out.println("Enter the id");
			int id = sc.nextInt();*/
			pstmt.setInt(1, id);
			
			/*System.out.println("Enter First Name");
			String fname = sc.next();*/
			pstmt.setString(2, fname);
			
			/*System.out.println("Enter last Name");
			String lname = sc.next();*/
			pstmt.setString(3, lname);
			
			/*System.out.println("Enter marks");
			double marks = sc.nextDouble();*/
			pstmt.setDouble(4, marks);
			
			int count = pstmt.executeUpdate();
			
			//4.process the Result
			System.out.println(count+" rows Affected");
		}  
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}
