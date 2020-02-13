let
url = new URL(window.location);
console.log(url);
let
id = url.searchParams.get("empId");
let
empName = url.searchParams.get("empName");
let
empGender = url.searchParams.get("empgender");
let
empMail = url.searchParams.get("mail");
let
org = url.searchParams.get("org");
let
empid = url.searchParams.get("id");
let
Employeeid = url.searchParams.get("Employeeid");
let
vehicletype = url.searchParams.get("typeofvehicle");
let
daily = url.searchParams.get("daily");
let
monthly = url.searchParams.get("monthly");
let
yearly = url.searchParams.get("yearly");
let
vname = url.searchParams.get("vname");
let
vtype = url.searchParams.get("vtype");
let
vnumber = url.searchParams.get("vnumber");

if ((id == null) && (Employeeid == null)) {
	console.log("into if");
	document.getElementById("empName").placeholder = empName;
	document.getElementById("empGender").placeholder = empGender;
	document.getElementById("empMail").placeholder = empMail;
	document.getElementById("empOrganisation").placeholder = org;
	document.getElementById("empid").value = empid;
	document.getElementById("empid").placeholder = empid;
	document.getElementById("empVehicleName").placeholder = vname;
	document.getElementById("empVehicleType").placeholder = vtype;
	document.getElementById("empVehicleNumber").placeholder = vnumber;

} else if (id == null) {
	document.getElementById("hiddenid").value = Employeeid;
	document.getElementById("hiddenvehicle").value = vehicletype;
	document.getElementById("dailyPass").value = daily;
	document.getElementById("monthlyPass").value = monthly;
	document.getElementById("yearlyPass").value = yearly;
} else {

	document.getElementById("employeeId").value = id;
	document.getElementById("employeeId").placeholder = id;
}

function display() {
	document.getElementById('empName').removeAttribute('readonly');
	document.getElementById('empGender').removeAttribute('readonly');
	document.getElementById('empMail').removeAttribute('readonly');
	document.getElementById('empOrganisation').removeAttribute('readonly');
}

function validateLogin() {

	if ((document.getElementById('login').value == null)
			|| (document.getElementById('login').value == "")) {
		alert("Mail can not be blank.");
		return false;
	}

	var pattern = /(^[a-zA-Z0-9]+[_\-\.]?[a-zA-Z0-9]+@[a-zA-Z]+.[a-zA-Z]+$)/i
	if (!(pattern.test(document.getElementById('login').value))) {
		alert("Invalid mail.");
		return false;
	}

	if ((document.getElementById('password').value == null)
			|| (document.getElementById('password').value == "")) {
		alert("Password can not be blank.");
		return false;
	}

	return true;
}

function validateRegForm() {

	if ((document.getElementById('employeeName').value == null)
			|| (document.getElementById('employeeName').value == "")) {
		alert("First Name can not be blank.");
		return false;
	}

	if (!(/[a-z]*[A-Z]*$/.test(document.getElementById('employeeName').value))) {
		alert("First Name can not contain a digit, space or special character.");
		return false;
	}

	if (((document.getElementById('maleRadio').checked) == false)
			&& ((document.getElementById('femaleRadio').checked) == false)) {
		alert("Please fill in gender.");

		return false;
	}
	if ((document.getElementById('mailId').value == null)
			|| (document.getElementById('mailId').value == "")) {
		alert("Mail can not be blank.");
		return false;
	}

	var pattern = /(^[a-zA-Z0-9]+[_\-\.]?[a-zA-Z0-9]+@[a-zA-Z]+.[a-zA-Z]+$)/i
	if (!(pattern.test(document.getElementById('mailId').value))) {
		alert("Invalid mail.");
		return false;
	}

	if ((document.getElementById('password').value == null)
			|| (document.getElementById('password').value == "")) {
		alert("Password can not be blank.");
		return false;
	}

	if ((document.getElementById('Cpassword').value == null)
			|| (document.getElementById('Cpassword').value == "")) {
		alert("Please confirm password.");
		return false;
	}

	var password = document.getElementById('password').value;
	var confirmPassword = document.getElementById('Cpassword').value;
	if (password != confirmPassword) {
		alert("Passwords do not match");
		return false;
	}

}
