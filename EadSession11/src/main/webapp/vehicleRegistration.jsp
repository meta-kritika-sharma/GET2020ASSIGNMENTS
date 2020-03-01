<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div align="center">
	<form:form action="/vehicleRegistration" modelAttribute="vehicleRegistration">
		<form:errors />

		<form:label path="vehicleName">Name</form:label>
		<br>
		<form:input path="vehicleName" type="text" id="employeevehicleName" placeholder="Enter vehicle name" />
		<br>
		<form:errors path="vehicleName" cssClass="text-danger" />
		<br>

		<form:label path="vehicleType">Type</form:label>
		<br>
		<form:input path="vehicleType" type="text" id="employeevehicleType" placeholder="Enter vehicle type" />
		<br>
		<form:errors path="vehicleType" cssClass="text-danger" />
		<br>

		<form:label path="vehicleNumber">Number</form:label>
		<br>
		<form:input path="vehicleNumber" type="text" id="employeevehicleNumber" placeholder="Enter vehicle number" />
		<br>
		<form:errors path="vehicleNumber" cssClass="text-danger" />
		<br>

		<form:label path="description">Description</form:label>
		<br>
		<form:textarea path="description" id="employeevehicleDescription" placeholder="Enter vehicle description" />
		<br>
		<form:errors path="description" cssClass="text-danger" />
		<br>

		<button type="submit">Submit</button>
	</form:form>
</div>