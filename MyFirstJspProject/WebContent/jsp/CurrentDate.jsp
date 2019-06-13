<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Date"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Current Date</title>
<style type="text/css">
	h1
	{
		color: red;
		background: yellow;
	}
</style>
</head>
<body>
	
	<%
		m1();
		Date d = new Date();
		String curdate = d.toString();
		
		
	%>
	<h1>
	Current Date And Time is 
	<%= curdate %>
	</h1>
	<h2> Value of x is <%= x %></h2>
	
	<%!
		int x = 10;
	
		public static void m1()
		{
			System.out.println("In m1()");
		
		}
	%>
</body>
</html>