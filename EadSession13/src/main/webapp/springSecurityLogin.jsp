<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="/" method="post">
	<div class="form-group">
		<div class="alert alert-primary text-center" role="alert">
			${SPRING_SECURITY_LAST_EXCEPTION.message}</div>
		<label for="exampleInputEmail1">Username</label> <input type="text"
			class="form-control" name="username" aria-describedby="usernameHelp"
			placeholder="Enter username">
	</div>
	<div class="form-group">
		<label for="exampleInputPassword1">Password</label>
		 <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
</form>


