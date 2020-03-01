<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div align="right">
	<form action="/logout">
		<input type="submit" name="logout" value="Log Out">
	</form>
</div>

<table border="1" align="center">
	<tr>
		<th>Employee Id</th>
		<th>Contact</th>
		<th>EmployeeName</th>
		<th>Gender</th>
		<th>Mail</th>
		<th>Organisation</th>

	</tr>


	<c:forEach items="${friendlist}" var="friends">

		<tr>

			<td>${friends.id}</td>
			<td>${friends.contactDetails}</td>
			<td>${friends.fullName}</td>
			<td>${friends.gender}</td>
			<td>${friends.mail}</td>
			<td>${friends.organisation}</td>
		</tr>

	</c:forEach>

</table>