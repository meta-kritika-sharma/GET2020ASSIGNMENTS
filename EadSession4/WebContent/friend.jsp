<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<div align="right">
		<form action="logout" method="post">
			<input type="submit" name="logout" value="Log Out">
		</form>
	</div>
	<table align="center" cellpadding="10%" style="text-align: left"
		border="1px">
		<tr>
			
			<th>Name</th>
			<th>Employee Email</th>
		</tr>
		<%
			ResultSet resultSet = (ResultSet) request
					.getAttribute("list");
			while (resultSet.next()) {
		%>
		<tr>
		
			<td><input name="email" type="text" size="25%"
				value="<%=resultSet.getString(1)%>" readonly></td>
			<td><%=resultSet.getString(2)%></td>
		
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>