<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form action="/passDetails" modelAttribute="pass">
	<div id="passOptions">
		<div>
			<form:radiobutton path="passChoice" id="dailyPassRadio" value="Daily"/>Daily
			<form:input type="text" path="dailypassValue" id="dailyPass" value="${dailyPrice}" />
		</div>
		<div>
			<form:radiobutton path="passChoice" id="monthlyPassRadio" value="Monthly"/>Monthly

			<form:input type="text" path="monthlypassValue" id="monthlyPass" value="${MonthlyPrice}"/>
		</div>
		<div>
			<form:radiobutton path="passChoice" id="yearlyPassRadio" value="Yearly"/>Yearly
			<form:input type="text" path ="yearlypassValue" id="yearlyPass" value="${YearlyPrice}"/>
		</div>
 		<div>
			<button type="submit">Get Pass</button>
		</div>
	</div>
</form:form>
