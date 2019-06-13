package edu.jspiders.batchProcessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingDemoDynamic
{
	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		try 
		{
			//1.loading Drivers
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.Get The Connections
			String dburl = "jdbc:mysql://localhost:3306/hejm19_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			
			//3.issue the sql query
			
			String query1 = "insert into student values(?,?,?,?)";
			String query2 = "insert into student_other_info values(?,?,?)";
			String query3 = "insert into gaurdian_info values(?,?,?)";
			
			pstmt = con.prepareStatement(query1);
			pstmt.setInt(1, 10);
			pstmt.setString(2, "gfj");
			pstmt.setString(3, "ryu");
			pstmt.setDouble(4, 98.63);
			pstmt.addBatch();
			
			pstmt = con.prepareStatement(query2);
			pstmt.setInt(1, 10);
			pstmt.setString(2, "gfj@gmail.com");
			pstmt.setString(3, "ryudf");
			pstmt.addBatch();
			
			pstmt = con.prepareStatement(query3);
			pstmt.setInt(1, 10);
			pstmt.setString(2, "asdf");
			pstmt.setString(3, "mother");
			pstmt.addBatch();
			
			int[] res = pstmt.executeBatch();
			
			for(int count : res)
			{
				System.out.println("no of rows Affected is "+count);
			}
			
			pstmt.clearBatch();
		} 
		catch (ClassNotFoundException | SQLException e) 
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
		}
	}
}
