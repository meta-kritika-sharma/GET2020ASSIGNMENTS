<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
 
	<div align="right">
		<form action="/logout">
			<input type="submit" name="logout" value="Log Out">
		</form>
	</div> 
<%=session.getAttribute("name") %>

<div align="center">
<a href = "/upload" >
<img src = "<%=session.getAttribute("name") %>" width="10%">
</a>
</div>

<div>
<table align="center" border="1">	
<tr>
<th>EmployeeId</th>
<th>Name</th>
<th>Gender</th>
<th>Mail</th>
<th>Organisation</th>
<th>VehicleName</th>
<th>VehicleType</th>
<th>VehicleNumber</th>
<th>Plan</th>
<th>Price</th>
<th>Description</th>
</tr>


<tr>
<td>${employee.id}</td>
<td>${employee.fullName}</td>
<td>${employee.gender}</td>
<td>${employee.mail}</td>
<td>${employee.organisation}</td>
<td>${vehicle.vehicleName}</td>
<td>${vehicle.vehicleType}</td>
<td>${vehicle.vehicleNumber}</td>
<td>${vehicle.plan}</td>
<td>${vehicle.price}</td>
<td>${vehicle.description}</td></tr>


</table>

</div>

<form action = "/friends" align="center">
<input id="friends" type="submit" name="friends" value="Friends"></form>

</body>
</html>
