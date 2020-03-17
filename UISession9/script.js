//Employee class
var Employee = /** @class */ (function () {
    function Employee() {
    }
    //function to change the display of fields according to field name
    Employee.prototype.employeeRegForm = function () {
        var employeeName = document.getElementById("employeeName").value;
        switch (inputField) {
            case 'employeeName':
                if (this.validateEmployeeName()) {
                    messageField.innerHTML = "Hi " + employeeName + ". May I know your gender?";
                    document.getElementById('employeeName').style.display = "none";
                    document.getElementById("employeeGender").style.display = "block";
                    inputField = "employeeGender";
                }
                break;
            case 'employeeGender':
                if (this.validateEmployeeGender()) {
                    messageField.innerHTML = "Hi " + employeeName + ". May I know your mail?";
                    document.getElementById("employeeGender").style.display = "none";
                    document.getElementById("employeeMail").style.display = "block";
                    inputField = "employeeMail";
                }
                break;
            case 'employeeMail':
                if (this.validateEmployeeMail()) {
                    messageField.innerHTML = "Hi " + employeeName + ". May I know your password?";
                    document.getElementById("employeeMail").style.display = "none";
                    document.getElementById("employeePassword").style.display = "block";
                    inputField = "employeePassword";
                }
                break;
            case 'employeePassword':
                if (this.validateEmployeePassword()) {
                    messageField.innerHTML = "Hi " + employeeName + ". Confirm your password.";
                    document.getElementById("employeePassword").style.display = "none";
                    document.getElementById("confirmPassword").style.display = "block";
                    inputField = "confirmPassword";
                }
                break;
            case 'confirmPassword':
                if (this.confirmPassword()) {
                    messageField.innerHTML = "Hi " + employeeName + ". May I know you contact?";
                    document.getElementById("confirmPassword").style.display = "none";
                    document.getElementById("contact").style.display = "block";
                    inputField = "contact";
                }
                break;
            case 'contact':
                if (this.validateContact()) {
                    document.getElementById("contact").style.display = "none";
                    document.getElementById("submitButton").style.display = "block";
                }
                break;
        }
    };
    //validating name of employee
    Employee.prototype.validateEmployeeName = function () {
        if (document.getElementById('employeeName').value == "") {
            document.getElementById('employeeName').style.borderBottomColor = "#ff0000";
            return false;
        }
        else if ((document.getElementById('employeeName').value).length < 2) {
            document.getElementById('employeeName').style.borderBottomColor = "#ff0000";
            document.getElementById('employeeName').style.borderBottomWidth = "4px";
            return false;
        }
        else if ((/^[A-Z]*[a-z]/.test(document.getElementById('employeeName').value)) == false) {
            document.getElementById('employeeName').style.borderBottomColor = "#ff0000";
            document.getElementById('employeeName').style.borderBottomWidth = "4px";
            return false;
        }
        else {
            document.getElementById('employeeName').style.borderBottomColor = "#ffffff";
            return true;
        }
    };
    //validating gender
    Employee.prototype.validateEmployeeGender = function () {
        if (((document.getElementById('maleRadio').checked) == false) && ((document.getElementById('femaleRadio').checked) == false)) {
            document.getElementById('employeeGender').style.borderColor = "#ff0000";
            document.getElementById('employeeGender').style.borderBottomWidth = "4px";
            return false;
        }
        else {
            document.getElementById('employeeGender').style.borderColor = "#ffffff";
            return true;
        }
    };
    //validating employee mail
    Employee.prototype.validateEmployeeMail = function () {
        var pattern = /(^[a-zA-Z]+[0-9]*[_\-\.]?[a-zA-Z0-9]+@[a-zA-Z]+.[a-zA-Z]+$)/;
        if (!(pattern.test(document.getElementById('employeeMail').value))) {
            document.getElementById('employeeMail').style.borderBottomColor = "#ff0000";
            document.getElementById('employeeMail').style.borderBottomWidth = "4px";
            return false;
        }
        else {
            document.getElementById('employeeMail').style.borderBottomColor = "#ffffff";
            return true;
        }
    };
    //validating employeePassword
    Employee.prototype.validateEmployeePassword = function () {
        var regexPassword = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).+$/;
        if (!document.getElementById("employeePassword").value.match(regexPassword)) {
            if (document.getElementById("employeePassword").value.length < 4) {
                document.getElementById("employeePassword").style.borderBottomColor = "#ff0000";
                document.getElementById("employeePassword").style.borderWidth = "3px";
                return false;
            }
        }
        else {
            if (document.getElementById("employeePassword").value.length < 8) {
                document.getElementById("employeePassword").style.borderColor = "orange";
                document.getElementById("employeePassword").style.borderWidth = "3px";
                return false;
            }
            if (document.getElementById("employeePassword").value.length > 8) {
                document.getElementById("employeePassword").style.borderColor = "green";
                document.getElementById("employeePassword").style.borderWidth = "3px";
                return true;
            }
        }
    };
    // matching password and confirm password
    Employee.prototype.confirmPassword = function () {
        if ((document.getElementById('employeePassword').value) != (document.getElementById('confirmPassword').value)) {
            document.getElementById('confirmPassword').style.borderBottomColor = "#ff0000";
            document.getElementById('confirmPassword').style.borderBottomWidth = "4px";
            return false;
        }
        document.getElementById('confirmPassword').style.borderBottomColor = "#ffffff";
        return true;
    };
    //validating contact
    Employee.prototype.validateContact = function () {
        if ((document.getElementById('contact').value).length < 8) {
            document.getElementById('contact').style.borderBottomColor = "#ff0000";
            document.getElementById('contact').style.borderBottomWidth = "4px";
            return false;
        }
        else {
            document.getElementById('contact').style.borderBottomColor = "#ffffff";
            return true;
        }
    };
    return Employee;
}());
//Vehicle class
var Vehicle = /** @class */ (function () {
    function Vehicle() {
    }
    //function to change the display of fields according to field name
    Vehicle.prototype.vehicleRegForm = function () {
        switch (inputField) {
            case 'vehicleName':
                if (this.validateVehicleName()) {
                    messageField.innerHTML = "What is your vehicle type?";
                    document.getElementById('vehicleName').style.display = "none";
                    document.getElementById("vehicleType").style.display = "block";
                    inputField = "vehicleType";
                }
                break;
            case 'vehicleType':
                if (this.validateVehicleType()) {
                    messageField.innerHTML = "What is your vehicle Number?";
                    document.getElementById("vehicleType").style.display = "none";
                    document.getElementById("vehicleNumber").style.display = "block";
                    inputField = "vehicleNumber";
                }
                break;
            case 'vehicleNumber':
                if (this.validateVehicleNumber()) {
                    messageField.innerHTML = "What is your vehicle description?";
                    document.getElementById("vehicleNumber").style.display = "none";
                    document.getElementById("description").style.display = "block";
                    inputField = "description";
                }
                break;
            case 'description':
                document.getElementById("description").style.display = "none";
                document.getElementById("submitVehicle").style.display = "block";
                break;
        }
    };
    //validating vehicle name
    Vehicle.prototype.validateVehicleName = function () {
        var pattern = /^[A-Za-z 0-9]*/;
        if (document.getElementById('vehicleName').value == "") {
            document.getElementById('vehicleName').style.borderBottomColor = "#ff0000";
            document.getElementById('vehicleName').style.borderBottomWidth = "4px";
            return false;
        }
        else if (!(pattern.test(document.getElementById('vehicleName').value))) {
            document.getElementById('vehicleName').style.borderBottomColor = "#ff0000";
            document.getElementById('vehicleName').style.borderBottomWidth = "4px";
            return false;
        }
        else {
            document.getElementById('vehicleName').style.borderBottomColor = "#ffffff";
            return true;
        }
    };
    //validating vehicle type selected
    Vehicle.prototype.validateVehicleType = function () {
        var vehicle = document.getElementById('vehicleType');
        var dailyValue, monthlyValue, yearlyValue;
        selectedOption = vehicle.options[vehicle.selectedIndex].value;
        if ((selectedOption != 'cycle') && (selectedOption != 'motorcycle') && (selectedOption != 'fourwheeler')) {
            document.getElementById('vehicleType').style.borderBottomColor = "#ff0000";
            document.getElementById('vehicleType').style.borderBottomWidth = "4px";
            return false;
        }
        else {
            document.getElementById('vehicleType').style.borderBottomColor = "#ffffff";
            if (selectedOption == 'cycle') {
                dailyValue = 5;
                monthlyValue = 100;
                yearlyValue = 500;
            }
            else if (selectedOption == 'motorcycle') {
                dailyValue = 100;
                monthlyValue = 200;
                yearlyValue = 1000;
            }
            else {
                dailyValue = 20;
                monthlyValue = 500;
                yearlyValue = 3500;
            }
            document.getElementById('dailyPass').value = String(dailyValue);
            document.getElementById('monthlyPass').value = String(monthlyValue);
            document.getElementById('yearlyPass').value = String(yearlyValue);
            return true;
        }
    };
    //validating vehicle number
    Vehicle.prototype.validateVehicleNumber = function () {
        if (document.getElementById('vehicleNumber').value == "") {
            document.getElementById('vehicleNumber').style.borderBottomColor = "#ff0000";
            document.getElementById('vehicelNumber').style.borderBottomWidth = "4px";
            return false;
        }
        else {
            document.getElementById('vehicleNumber').style.borderBottomColor = "#ffffff";
            return true;
        }
    };
    return Vehicle;
}());
var xmlHttp = new XMLHttpRequest();
var theUrl = "http://api.currencylayer.com/live?access_key=2243dba5ea20e9d54f41fc7da3486f04&currencies=USD,INR,JPY";
xmlHttp.open("GET", theUrl, false);
xmlHttp.send(null);
var response = JSON.parse(xmlHttp.responseText);
var currency = response.quotes;
var currentCurrency = "INR";
var selectedOption;
var inputField;
var inputForm;
var messageField = (document.getElementById('messageField'));
//Conversion of pass values into different currencies.
function convertCurrency(currencyValue) {
    if (currentCurrency == "INR") {
        return currencyValue;
    }
    else if (currentCurrency == "USD") {
        return currencyValue / currency.USDINR;
    }
    else {
        return currencyValue * currency.USDJPY / currency.USDINR;
    }
}
//Assigning changed currency values.
function changeCurrency() {
    if (selectedOption == 'cycle') {
        document.getElementById('dailyPass').value = String(convertCurrency(5));
        document.getElementById('monthlyPass').value = String(convertCurrency(100));
        document.getElementById('yearlyPass').value = String(convertCurrency(500));
    }
    else if (selectedOption == 'motorcycle') {
        document.getElementById('dailyPass').value = String(convertCurrency(10));
        document.getElementById('monthlyPass').value = String(convertCurrency(200));
        document.getElementById('yearlyPass').value = String(convertCurrency(1000));
    }
    else {
        document.getElementById('dailyPass').value = String(convertCurrency(20));
        document.getElementById('monthlyPass').value = String(convertCurrency(500));
        document.getElementById('yearlyPass').value = String(convertCurrency(3500));
    }
}
function toInr() {
    currentCurrency = "INR";
    changeCurrency();
}
function toUsd() {
    currentCurrency = "USD";
    changeCurrency();
}
function toYen() {
    currentCurrency = "YEN";
    changeCurrency();
}
//finction to display initial message and employee name field
function employeeDetails() {
    messageField.style.display = "block";
    document.getElementById("employeeName").style.display = "block";
    inputField = "employeeName";
    inputForm = "employeeForm";
}
//Function to display initial message and input vehicle name field.
function vehicleDetails() {
    document.getElementById('employeeRegistrationForm').style.display = "none";
    messageField.innerHTML = "Your employee id = 1. Please enter vehicle name.";
    document.getElementById('employeeId').style.display = "block";
    document.getElementById("vehicleName").style.display = "block";
    inputField = "vehicleName";
    inputForm = "vehicleForm";
}
//function to display pass details
function passDetails() {
    document.getElementById('vehicleRegistrationForm').style.display = "none";
    messageField.innerHTML = "Choose Pass";
    document.getElementById("passForm").style.display = "block";
    document.getElementById("getPass").style.display = "block";
    inputField = "passChoice";
}
var employeeObject = new Employee();
var vehicleObject = new Vehicle();
// this code will be executed every time enter key is pressed.
window.addEventListener("keypress", function (event) {
    if (event.keyCode == 13) {
        console.log("into enter");
        if (inputForm == "employeeForm") {
            employeeObject.employeeRegForm();
        }
        else if (inputForm == "vehicleForm") {
            vehicleObject.vehicleRegForm();
        }
    }
});
//validating pass choice selection
function validateShowPass() {
    if ((document.getElementById('dailyPassRadio').checked == false) && (document.getElementById('monthlyPassRadio').checked == false) && (document.getElementById('yearlyPassRadio').checked == false)) {
        document.getElementById('passDiv').style.borderBottomColor = "ff0000";
        document.getElementById('passDiv').style.borderBottomWidth = "4px";
        return false;
    }
    else {
        document.getElementById('passDiv').style.borderBottomColor = "ffffff";
        messageField.style.display = "none";
        document.getElementById('passValue').style.display = "block";
        var finalCost;
        if (document.getElementById('dailyPassRadio').checked) {
            finalCost = document.getElementById('dailyPass').value;
        }
        else if (document.getElementById('monthlyPassRadio').checked) {
            finalCost = document.getElementById('monthlyPass').value;
        }
        else if (document.getElementById('yearlyPassRadio').checked) {
            finalCost = document.getElementById('yearlyPass').value;
        }
        document.getElementById('passDiv').style.display = "none";
        document.getElementById('passValue').innerHTML = "Pass value is " + finalCost;
        return true;
    }
}
//function to validate password on key press
function validateEmployeePassword() {
    employeeObject.validateEmployeePassword();
}
