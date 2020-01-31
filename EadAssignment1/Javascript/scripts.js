var employeeId = 0;

function employeeRegister() {

    document.getElementById('employeeId').value = employeeId + 1;
    document.getElementById('EmpRegForm').innerHTML = "<center>Your registration id is " + (employeeId + 1) + "</center>";
    document.getElementById('vehicleRegForm').style.display = "block";
    document.getElementById('formTitle').innerText = "Vehicle Registration Form";

}

var xmlHttp = new XMLHttpRequest();
var theUrl = "http://api.currencylayer.com/live?access_key=2243dba5ea20e9d54f41fc7da3486f04&currencies=USD,INR,JPY";
xmlHttp.open("GET", theUrl, false);
xmlHttp.send(null);
var response = JSON.parse(xmlHttp.responseText);
var currency = response.quotes;
var currentCurrency = "INR";
var selectedOption;
var vehicleType;

function convertCurrency(currencyValue) {
    if (currentCurrency == "INR") {
        return currencyValue;
    } else if (currentCurrency == "USD") {
        return currencyValue / currency.USDINR;
    } else {
        return currencyValue * currency.USDJPY / currency.USDINR;
    }
}

function changeCurrency() {
    if (selectedOption == 1) {
        document.getElementById('dailyPass').value = convertCurrency(5);
        document.getElementById('monthlyPass').value = convertCurrency(100);
        document.getElementById('yearlyPass').value = convertCurrency(500);
    } else if (selectedOption == 2) {
        document.getElementById('dailyPass').value = convertCurrency(10);
        document.getElementById('monthlyPass').value = convertCurrency(200);
        document.getElementById('yearlyPass').value = convertCurrency(1000);

    } else {
        document.getElementById('dailyPass').value = convertCurrency(20);
        document.getElementById('monthlyPass').value = convertCurrency(500);
        document.getElementById('yearlyPass').value = convertCurrency(3500);

    }
}

function vehicleRegister() {
    vehicleType = document.getElementById("typeOfVehicle");

    document.getElementById('vehicleRegForm').innerHTML = "";
    document.getElementById('showPass').style.display = "block";
    document.getElementById('formTitle').innerText = "Passes";
    selectedOption = vehicleType.options[vehicleType.selectedIndex].value;
    changeCurrency();
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

function display() {
    if ((document.getElementById('dailyPassRadio').checked == false) && (document.getElementById('monthlyPassRadio').checked == false) && (document.getElementById('yearlyPassRadio').checked == false)) {
        //document.getElementById('optionError').innerText = "Please select an option."
        alert("Please select an option.");
        return false;
    } else {
        document.getElementById('optionError').innerText = ""

        document.getElementById('displayTable').style.display = "block";
        var finalCost;
        if (document.getElementById('dailyPassRadio').checked) {
            finalCost = document.getElementById('dailyPass').value;
        } else if (document.getElementById('monthlyPassRadio').checked) {
            finalCost = document.getElementById('monthlyPass').value;
        } else if (document.getElementById('yearlyPassRadio').checked) {
            finalCost = document.getElementById('yearlyPass').value;
        }

        document.getElementById('showPass').style.display = "none";

        document.getElementById('finalPriceText').value = finalCost;
        document.getElementById('formTitle').innerText = "Pass Cost"
    }
}

function validateEmpRegForm() {
    var flag = 1;
    if (document.getElementById('employeeName').value == "") {
        document.getElementById('employeeName').style.borderBottomColor = "#ff0000"
        document.getElementById('nameError').innerText = "Field cannot be empty.";
        flag = 0;
        return false;
    } else if ((document.getElementById('employeeName').value).length < 2) {
        document.getElementById('employeeName').style.borderBottomColor = "#ff0000"
        document.getElementById('nameError').innerText = "Name must have at least two characters.";
        flag = 0;
        return false
    } else if ((/^[A-Z]*[a-z]/.test(document.getElementById('employeeName').value)) == false) {
        document.getElementById('employeeName').style.borderBottomColor = "#ff0000"
        document.getElementById('nameError').innerText = "Name cannot be digit";
        flag = 0;
        return false
    } else {
        document.getElementById('employeeName').style.borderBottomColor = "#ffffff"
        document.getElementById('nameError').innerText = "";
        document.getElementById('name').value = document.getElementById('employeeName').value
        flag = 1;
    }
    if (((document.getElementById('maleRadio').checked) == false) && ((document.getElementById('femaleRadio').checked) == false)) {
        document.getElementById('genderError').innerText = "Please fill in gender.";
        flag = 0;
        return false;
    } else {
        document.getElementById('genderError').innerText = "";
        flag = 1;
    }
    var pattern = /(^[a-zA-Z]+[_\-\.]?[a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]+$)/i
    var regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,}$/;
    if (!(pattern.test(document.getElementById('mailid').value))) {
        document.getElementById('mailid').style.borderBottomColor = "#ff0000"
        document.getElementById('mailError').innerText = "Enter valid email.";
        flag = 0;
        return false
    } else {
        document.getElementById('mailid').style.borderBottomColor = "#ffffff"
        document.getElementById('mail').value = document.getElementById('mailid').value
        document.getElementById('mailError').innerText = "";
        flag = 1;
    }
    if ((document.getElementById('contact').value).length < 8) {
        document.getElementById('contact').style.borderBottomColor = "#ff0000"
        document.getElementById('contactError').innerText = "Contact length should be 8.";
        flag = 0;
        return false
    } else {
        document.getElementById('contact').style.borderBottomColor = "#ffffff"
        document.getElementById('contactDetails').value = document.getElementById('contact').value
        document.getElementById('contactError').innerText = "";
        flag = 1;
    }
    if ((document.getElementById('password').value).length < 8) {
        document.getElementById('password').style.borderBottomColor = "#ff0000"
        document.getElementById('passwordError').innerText = "Inadequate password length.";
        flag = 0;
        return false
    } else if (!(regex.test(document.getElementById('password').value))) {
        document.getElementById('password').style.borderBottomColor = "#ff0000"
        document.getElementById('passwordError').innerText = "Password not strong enough."
        flag = 0;
        return false
    } else {
        document.getElementById('password').style.borderBottomColor = "#ffffff"
        document.getElementById('passwordError').innerText = "";
        flag = 1;
    }

    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirmPassword').value;
    if (password != confirmPassword) {
        document.getElementById('confirmPassword').style.borderBottomColor = "#ff0000"
        flag = 0;
        document.getElementById('confirmPasswordError').innerText = "Passwords do not match";
        return false;
    } else {
        document.getElementById('confirmPassword').style.borderBottomColor = "#ffffff"
        document.getElementById('confirmPasswordError').innerText = "";
        flag = 1;
    }
    if (flag == 1) {
        employeeRegister();
    }

}

function validateVehicleRegForm() {
    var pattern = /^[A-Za-z 0-9]*/
    var vehicle = document.getElementById('typeOfVehicle');
    selectedOption = vehicle.options[vehicle.selectedIndex].value;

    if (document.getElementById('vehicleName').value == "") {
        document.getElementById('vehicleNameError').innerText = "Field can't be empty.";
        flag = 0;
        return false
    } else if (!(pattern.test(document.getElementById('vehicleName').value))) {
        document.getElementById('vehicleNameError').innerText = "Invalid vehicle name";
        flag = 0;
        return false
    } else {
        document.getElementById('nameOfVehicle').value = document.getElementById('vehicleName').value
        document.getElementById('vehicleNameError').innerText = "";
        flag = 1;

    }

    if ((selectedOption != 1) && (selectedOption != 2) && (selectedOption != 3)) {
        document.getElementById('vehicleTypeError').innerText = "Please select an item."
        flag = 0;
        return false
    } else {
        document.getElementById('vehicleTypeError').innerText = ""
        flag = 1;
    }

    if (document.getElementById('vehicleNumber').value == "") {
        document.getElementById('vehicleNumberError').innerText = "Field can't be empty";
        flag = 0;
        return false
    } else {
        document.getElementById('numberOfVehicle').value =
            document.getElementById('vehicleNumber').value
        document.getElementById('vehicleNumberError').innerText = ""
        flag = 1;
    }
    if (document.getElementById('description').value == "") {
        document.getElementById('descriptionError').innerText = "Field can't be empty.";
        flag = 0;
        return false
    } else {
        document.getElementById('descriptionError').innerText = "";
        flag = 1;
    }

    flag = 1;
    if (flag == 1) {
        vehicleRegister();
    }
}

function validateShowPass() {
    if ((document.getElementById('dailyPassRadio').checked == false) && (document.getElementById('monthlyPassRadio').checked == false) && (document.getElementById('yearlyPassRadio').checked == false)) {
        alert("Please select an option");
        return false;
    }
}