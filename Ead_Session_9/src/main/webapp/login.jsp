<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div align ="center">
<form:form modelAttribute="login" action="/login">

<form:errors/>
<form:label path="mail">E- Mail</form:label><br>
<form:input path="mail" type="email" id= "employeeMail" placeholder="Enter e-mail id"/><br>
<form:errors path="mail" cssClass="text-danger" style="color:red"/><br>
<form:label path="password">Password</form:label><br>
<form:input path="password" type="password" id= "employeePassword" placeholder="Enter password"/><br>
<form:errors path="password" cssClass="text-danger" style="color:red"/><br>
<button type="submit">Submit</button>
</form:form>
</div>



<div align="center">
<a href = "register">Register</a>
</div>

<div align="center">
${ msg}
</div>