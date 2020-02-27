<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<table class="table table-dark" border="1px" align="center">
		<thead>
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Father's Name</th>
				<th>Email</th>
				<th>Class</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${students}">
				<tr>
					<th>${student.id}</th>
					<th>${student.first_name}</th>
					<th>${student.last_name}</th>
					<th>${student.father_name}</th>
					<th>${student.email}</th>
					<th>${student.std}</th>
					<th>${student.age}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

