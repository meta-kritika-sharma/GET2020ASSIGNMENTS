//Employee class
class Employee{

    //function to change the display of fields according to field name
    employeeRegForm(): void{
        let employeeName = (<HTMLInputElement>document.getElementById("employeeName")).value; 
        switch(inputField){
            case 'employeeName':
                if (this.validateEmployeeName()){
                    messageField.innerHTML = "Hi "+employeeName+". May I know your gender?";
                    (<HTMLElement>document.getElementById('employeeName')).style.display = "none";
                    (<HTMLElement>document.getElementById("employeeGender")).style.display="block";
                    inputField= "employeeGender";
                }
                break;
            case 'employeeGender':
                if (this.validateEmployeeGender()){
                    messageField.innerHTML = "Hi "+employeeName+". May I know your mail?";
                    (<HTMLElement>document.getElementById("employeeGender")).style.display="none";
                    (<HTMLElement>document.getElementById("employeeMail")).style.display="block";
                    inputField= "employeeMail";
                }
                break;
            case 'employeeMail' :
                if (this.validateEmployeeMail()){
                    messageField.innerHTML = "Hi "+employeeName+". May I know your password?";
                    (<HTMLElement>document.getElementById("employeeMail")).style.display="none";
                    (<HTMLElement>document.getElementById("employeePassword")).style.display="block";
                    inputField= "employeePassword";
                }
                break;
            case 'employeePassword' :
                if (this.validateEmployeePassword()){
                    messageField.innerHTML = "Hi "+employeeName+". Confirm your password.";
                    (<HTMLElement>document.getElementById("employeePassword")).style.display="none";
                    (<HTMLElement>document.getElementById("confirmPassword")).style.display="block";
                    inputField= "confirmPassword";
                }
                break;
            case 'confirmPassword' :
                if (this.confirmPassword()){
                    messageField.innerHTML = "Hi "+employeeName+". May I know you contact?";
                    (<HTMLElement>document.getElementById("confirmPassword")).style.display="none";
                    (<HTMLElement>document.getElementById("contact")).style.display="block";
                    inputField= "contact";
                }
                break;
            case 'contact' :
                if (this.validateContact()){
                    (<HTMLElement>document.getElementById("contact")).style.display="none";
                    (<HTMLElement>document.getElementById("submitButton")).style.display="block";
                }
                break;
            }
    }

    //validating name of employee
    validateEmployeeName():Boolean{
    if ((<HTMLInputElement>document.getElementById('employeeName')).value == "") {
        (<HTMLElement>document.getElementById('employeeName')).style.borderBottomColor = "#ff0000";
        return false;
            } else if (((<HTMLInputElement>document.getElementById('employeeName')).value).length < 2) {
                (<HTMLInputElement>document.getElementById('employeeName')).style.borderBottomColor = "#ff0000";
                (<HTMLInputElement>document.getElementById('employeeName')).style.borderBottomWidth = "4px";
                return false
            } else if ((/^[A-Z]*[a-z]/.test((<HTMLInputElement>document.getElementById('employeeName')).value)) == false) {
                (<HTMLElement>document.getElementById('employeeName')).style.borderBottomColor = "#ff0000";
                (<HTMLElement>document.getElementById('employeeName')).style.borderBottomWidth = "4px";
                return false
            } else {
                (<HTMLElement>document.getElementById('employeeName')).style.borderBottomColor = "#ffffff";
                return true;
            }
    }

    //validating gender
    validateEmployeeGender() : Boolean{
        if ((((<HTMLInputElement>document.getElementById('maleRadio')).checked) == false) && (((<HTMLInputElement>document.getElementById('femaleRadio')).checked) == false)) {
            (<HTMLElement>document.getElementById('employeeGender')).style.borderColor="#ff0000";
            (<HTMLElement>document.getElementById('employeeGender')).style.borderBottomWidth = "4px";
            return false;
        } else {
            (<HTMLInputElement>document.getElementById('employeeGender')).style.borderColor="#ffffff";
            return true;
        }
    }

    //validating employee mail
    validateEmployeeMail(){
        let pattern = /(^[a-zA-Z]+[0-9]*[_\-\.]?[a-zA-Z0-9]+@[a-zA-Z]+.[a-zA-Z]+$)/;
        if (!(pattern.test((<HTMLInputElement>document.getElementById('employeeMail')).value))) {
            (<HTMLElement>document.getElementById('employeeMail')).style.borderBottomColor = "#ff0000";
            (<HTMLElement>document.getElementById('employeeMail')).style.borderBottomWidth = "4px";
            return false;
        } else {
            (<HTMLElement>document.getElementById('employeeMail')).style.borderBottomColor = "#ffffff";
            return true;    
        }
    }

    //validating employeePassword
    validateEmployeePassword(){
        let regexPassword = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).+$/;
        if (!(<HTMLInputElement>document.getElementById("employeePassword")).value.match(regexPassword)) {
            if ((<HTMLInputElement>document.getElementById("employeePassword")).value.length < 4) {
                (<HTMLElement>document.getElementById("employeePassword")).style.borderBottomColor = "#ff0000";
                (<HTMLElement>document.getElementById("employeePassword")).style.borderWidth = "3px";
                return false;
            }
        } else {
            if ((<HTMLInputElement>document.getElementById("employeePassword")).value.length < 8) {
                (<HTMLElement>document.getElementById("employeePassword")).style.borderColor = "orange";
                (<HTMLElement>document.getElementById("employeePassword")).style.borderWidth = "3px";
                return false;
            }
            if ((<HTMLInputElement>document.getElementById("employeePassword")).value.length > 8) {
                (<HTMLInputElement>document.getElementById("employeePassword")).style.borderColor = "green";
                (<HTMLInputElement>document.getElementById("employeePassword")).style.borderWidth = "3px";
                return true;
            }
        }   
    }

    // matching password and confirm password
    confirmPassword(){
        if (((<HTMLInputElement>document.getElementById('employeePassword')).value)!=((<HTMLInputElement>document.getElementById('confirmPassword')).value)){
            (<HTMLInputElement>document.getElementById('confirmPassword')).style.borderBottomColor = "#ff0000";
            (<HTMLInputElement>document.getElementById('confirmPassword')).style.borderBottomWidth = "4px";
            return false;    
        }
        (<HTMLInputElement>document.getElementById('confirmPassword')).style.borderBottomColor = "#ffffff";
        return true;
    }

    //validating contact
    validateContact(){
        if (((<HTMLInputElement>document.getElementById('contact')).value).length < 8) {
            (<HTMLInputElement>document.getElementById('contact')).style.borderBottomColor = "#ff0000";
            (<HTMLInputElement>document.getElementById('contact')).style.borderBottomWidth = "4px";
            return false;
        } else {
            (<HTMLInputElement>document.getElementById('contact')).style.borderBottomColor = "#ffffff";
            return true;
        }  
    }
}

//Vehicle class
class Vehicle{

    //function to change the display of fields according to field name
    vehicleRegForm():void{
        switch (inputField){
        case 'vehicleName':
            if (this.validateVehicleName()){
                messageField.innerHTML = "What is your vehicle type?";
                (<HTMLElement>document.getElementById('vehicleName')).style.display ="none";
                (<HTMLElement>document.getElementById("vehicleType")).style.display = "block";
                inputField = "vehicleType";
            }
            break;
        case 'vehicleType':
            if (this.validateVehicleType()){
                messageField.innerHTML = "What is your vehicle Number?";
                (<HTMLElement>document.getElementById("vehicleType")).style.display = "none";
                (<HTMLElement>document.getElementById("vehicleNumber")).style.display = "block";
                inputField = "vehicleNumber";
            }
            break;
        case 'vehicleNumber':
            if (this.validateVehicleNumber()){
                messageField.innerHTML = "What is your vehicle description?";
                (<HTMLElement>document.getElementById("vehicleNumber")).style.display = "none";
                (<HTMLElement>document.getElementById("description")).style.display = "block";
                inputField = "description";                
            }
            break;
        case 'description':
            (<HTMLElement>document.getElementById("description")).style.display = "none";
            (<HTMLElement>document.getElementById("submitVehicle")).style.display = "block";     
            break;
        }
    }
    
    //validating vehicle name
    validateVehicleName(){
        let pattern = /^[A-Za-z 0-9]*/;
        if ((<HTMLInputElement>document.getElementById('vehicleName')).value == "") {
            (<HTMLElement>document.getElementById('vehicleName')).style.borderBottomColor = "#ff0000";
            (<HTMLElement>document.getElementById('vehicleName')).style.borderBottomWidth = "4px";
            return false;
        } else if (!(pattern.test((<HTMLInputElement>document.getElementById('vehicleName')).value))) {
            (<HTMLElement>document.getElementById('vehicleName')).style.borderBottomColor = "#ff0000";
            (<HTMLElement>document.getElementById('vehicleName')).style.borderBottomWidth = "4px";
            return false;
        } else {
            (<HTMLElement>document.getElementById('vehicleName')).style.borderBottomColor = "#ffffff";
            return true;
        }
    }

    //validating vehicle type selected
    validateVehicleType(){
        let vehicle = <HTMLSelectElement>document.getElementById('vehicleType');
        let dailyValue, monthlyValue, yearlyValue;
        selectedOption = vehicle.options[vehicle.selectedIndex].value;
        if ((selectedOption != 'cycle') && (selectedOption != 'motorcycle') && (selectedOption != 'fourwheeler')) {
            (<HTMLElement>document.getElementById('vehicleType')).style.borderBottomColor = "#ff0000";
            (<HTMLElement>document.getElementById('vehicleType')).style.borderBottomWidth = "4px";
            return false;
        } else {
            (<HTMLElement>document.getElementById('vehicleType')).style.borderBottomColor = "#ffffff";
            if (selectedOption=='cycle'){
                dailyValue = 5
                monthlyValue = 100
                yearlyValue = 500
            }
            else if (selectedOption == 'motorcycle'){
                dailyValue = 100
                monthlyValue = 200
                yearlyValue = 1000
            }
            else{
                dailyValue = 20
                monthlyValue = 500
                yearlyValue =3500
        }
        (<HTMLInputElement>document.getElementById('dailyPass')).value = String(dailyValue);
        (<HTMLInputElement>document.getElementById('monthlyPass')).value = String(monthlyValue);
        (<HTMLInputElement>document.getElementById('yearlyPass')).value = String(yearlyValue);
        return true;
        }
    }

    //validating vehicle number
    validateVehicleNumber(){
        if ((<HTMLInputElement>document.getElementById('vehicleNumber')).value == "") {
            (<HTMLElement>document.getElementById('vehicleNumber')).style.borderBottomColor = "#ff0000";
            (<HTMLElement>document.getElementById('vehicelNumber')).style.borderBottomWidth = "4px";
            return false
        }else {
            (<HTMLElement>document.getElementById('vehicleNumber')).style.borderBottomColor = "#ffffff";
            return true;
        }
    }
}   

var xmlHttp = new XMLHttpRequest();
var theUrl = "http://api.currencylayer.com/live?access_key=2243dba5ea20e9d54f41fc7da3486f04&currencies=USD,INR,JPY";
xmlHttp.open("GET", theUrl, false);
xmlHttp.send(null);
var response = JSON.parse(xmlHttp.responseText);
var currency = response.quotes;
var currentCurrency = "INR";
var selectedOption : string;
var inputField :string;
var inputForm : string;
var messageField = <HTMLElement>(document.getElementById('messageField'));

//Conversion of pass values into different currencies.
function convertCurrency(currencyValue :number) : number {
    if (currentCurrency == "INR") {
        return currencyValue;
    } else if (currentCurrency == "USD") {
        return currencyValue / currency.USDINR;
    } else {
        return currencyValue * currency.USDJPY / currency.USDINR;
    }
}

//Assigning changed currency values.
function changeCurrency() : void{
    if (selectedOption == 'cycle') {
        (<HTMLInputElement>document.getElementById('dailyPass')).value = String(convertCurrency(5));
        (<HTMLInputElement>document.getElementById('monthlyPass')).value = String(convertCurrency(100));
        (<HTMLInputElement>document.getElementById('yearlyPass')).value = String(convertCurrency(500));
    } else if (selectedOption == 'motorcycle') {
        (<HTMLInputElement>document.getElementById('dailyPass')).value = String(convertCurrency(10));
        (<HTMLInputElement>document.getElementById('monthlyPass')).value = String(convertCurrency(200));
        (<HTMLInputElement>document.getElementById('yearlyPass')).value = String(convertCurrency(1000));

    } else {
        (<HTMLInputElement>document.getElementById('dailyPass')).value = String(convertCurrency(20));
        (<HTMLInputElement>document.getElementById('monthlyPass')).value = String(convertCurrency(500));
        (<HTMLInputElement>document.getElementById('yearlyPass')).value = String(convertCurrency(3500));
    }
}

function toInr() : void{
    currentCurrency = "INR";
    changeCurrency();
}

function toUsd() : void {
    currentCurrency = "USD";
    changeCurrency();
}

function toYen() : void{
    currentCurrency = "YEN";
    changeCurrency();
}

//finction to display initial message and employee name field
function employeeDetails() : void{
    messageField.style.display ="block";
    (<HTMLElement>document.getElementById("employeeName")).style.display="block";
    inputField = "employeeName"
    inputForm="employeeForm";
}

//Function to display initial message and input vehicle name field.
function vehicleDetails() : void{
    (<HTMLElement>document.getElementById('employeeRegistrationForm')).style.display = "none";
    messageField.innerHTML = "Your employee id = 1. Please enter vehicle name.";
    (<HTMLElement>document.getElementById('employeeId')).style.display = "block";
    (<HTMLElement>document.getElementById("vehicleName")).style.display="block";
    inputField = "vehicleName";
    inputForm="vehicleForm";
}

//function to display pass details
function passDetails() : void{
    (<HTMLElement>document.getElementById('vehicleRegistrationForm')).style.display ="none";
    messageField.innerHTML = "Choose Pass";
    (<HTMLElement>document.getElementById("passForm")).style.display="block";
    (<HTMLElement>document.getElementById("getPass")).style.display="block";
    inputField = "passChoice";
}


var employeeObject = new Employee();
var vehicleObject = new Vehicle();
// this code will be executed every time enter key is pressed.
window.addEventListener("keypress", function (event){
    if (event.keyCode == 13){
        console.log("into enter");
        if (inputForm=="employeeForm"){
            employeeObject.employeeRegForm();
        }
        else if (inputForm=="vehicleForm"){
            vehicleObject.vehicleRegForm();
        }
    }
});

//validating pass choice selection
function validateShowPass(): boolean{
    if (((<HTMLInputElement>document.getElementById('dailyPassRadio')).checked == false) && ((<HTMLInputElement>document.getElementById('monthlyPassRadio')).checked == false) && ((<HTMLInputElement>document.getElementById('yearlyPassRadio')).checked == false)) {
        (<HTMLInputElement>document.getElementById('passDiv')).style.borderBottomColor = "ff0000";
        (<HTMLElement>document.getElementById('passDiv')).style.borderBottomWidth = "4px";
        return false;
    }
    else{
        (<HTMLElement>document.getElementById('passDiv')).style.borderBottomColor = "ffffff";
        messageField.style.display = "none";
        (<HTMLElement>document.getElementById('passValue')).style.display ="block";
        var finalCost;
        if ((<HTMLInputElement>document.getElementById('dailyPassRadio')).checked) {
            finalCost = (<HTMLInputElement>document.getElementById('dailyPass')).value;
        } else if ((<HTMLInputElement>document.getElementById('monthlyPassRadio')).checked) {
            finalCost = (<HTMLInputElement>document.getElementById('monthlyPass')).value;
        } else if ((<HTMLInputElement>document.getElementById('yearlyPassRadio')).checked) {
            finalCost = (<HTMLInputElement>document.getElementById('yearlyPass')).value;
        }
        (<HTMLElement>document.getElementById('passDiv')).style.display ="none";
        (<HTMLElement>document.getElementById('passValue')).innerHTML = "Pass value is "+finalCost;
        return true;
    }
}

//function to validate password on key press
function validateEmployeePassword():void{
    employeeObject.validateEmployeePassword();
}

