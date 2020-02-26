<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div align ="center">
<form:form action="/register" modelAttribute="employee">

<form:errors/>

<form:label path="fullName">Name</form:label><br>
<form:input path="fullName" type="text" id= "employeeName" placeholder="Enter name"/><br>
<form:errors path="fullName" cssClass="text-danger" style="color:red" /><br>

<form:radiobutton path="gender" id= "employeeMaleGender" value="male"/>Male
<form:radiobutton path="gender" id= "employeeFemaleGender" value="female"/>FeMale<br>
<form:errors path="gender" cssClass="text-danger" style="color:red"/><br>

<form:label path="mail">E- Mail</form:label><br>
<form:input path="mail" type="email" id= "employeeMail" placeholder="Enter e-mail id"/><br>
<form:errors path="mail" cssClass="text-danger" style="color:red"/><br>
<form:label path="password">Password</form:label><br>
<form:input path="password" type="password" id= "employeePassword" placeholder="Enter password"/><br>
<form:errors path="password" cssClass="text-danger" style="color:red"/><br>

<form:label path="confirmPassword">Confirm Password</form:label><br>
<form:input path="confirmPassword" type="password" id= "employeeConfirmPassword" placeholder="Re-Enter password"/><br>
<form:errors path="confirmPassword" cssClass="text-danger" style="color:red"/><br>

<form:label path="organisation">Organisation</form:label><br>
<form:select path = "organisation" id = "employeeOrganisation">
                   <form:option value = "M1" label = "M1"/>
                   <form:option value = "M2" label = "M2"/>
                   <form:option value = "M3" label = "M3"/>
               </form:select><br><br>
<form:errors path="organisation" cssClass="text-danger" style="color:red"/><br>
<form:label path="contactDetails">Contact</form:label><br>
<form:input path="contactDetails" type="text" id= "employeeContact" placeholder="Enter contact details"/><br>
<form:errors path="contactDetails" cssClass="text-danger" style="color:red"/><br>
<button type="submit">Submit</button>
</form:form>
</div>
