package edu.jspiders.batchProcessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingDemo
{
	public static void main(String[] args) 
	{
		Connection con = null;
		Statement stmt = null;
		try 
		{
			//1.loading Drivers
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.Get The Connections
			String dburl = "jdbc:mysql://localhost:3306/hejm19_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			
			//3.issue the sql query
			con.setAutoCommit(false);
			String query1 = "insert into student values(3,'Raghu','Ram',56.69)";
			String query2 = "insert into student_other_info values(3,'raghu.ram@gmail.com','qwert@123')";
			String query3 = "insert into gaurdian_info values(3,'Ramanna','father')";
			
			stmt = con.createStatement();
			  
			stmt.addBatch(query1);
			stmt.addBatch(query2);
			stmt.addBatch(query3);
			
			int[] res = stmt.executeBatch();
			con.commit();
			for(int count : res)
			{
				System.out.println("no of rows Affected is "+count);
			}
			
			stmt.clearBatch();
		} 
		catch (ClassNotFoundException e) 
		{

			
			
			
			
			
			
			
			
			e.printStackTrace();
		}
		catch(SQLException e)
		{
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
		}
	}
}
