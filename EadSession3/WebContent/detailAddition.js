function validate() {

    console.log(document.studentForm.firstNameOfStudent.value)
    if ((document.studentForm.firstNameOfStudent.value == null) ||
        (document.studentForm.firstNameOfStudent.value == "")) {
        alert("First Name can not be blank.");
        return false;
    }

    if (!(/[a-z]*[A-Z]*$/.test(document.studentForm.firstNameOfStudent.value))) {
        alert("First Name can not contain a digit, space or special character.");
        return false;
    }

    if ((document.studentForm.lastNameOfStudent.value == null) ||
        (document.studentForm.lastNameOfStudent.value == "")) {
        alert("Last Name can not be blank.");
        return false;
    }

    if (!(/[a-z]*[A-Z]*$/.test(document.studentForm.lastNameOfStudent.value))) {
        alert("Last Name can not contain a digit, space or special character.");
        return false;
    }

    if ((document.studentForm.nameOfFather.value == null) ||
        (document.studentForm.nameOfFather.value == "")) {
        alert("Last Name can not be blank.");
        return false;
    }

    if (!(/[a-z]*[A-Z]*$/.test(document.studentForm.nameOfFather.value))) {
        alert("Name can not contain a digit.");
        return false;
    }

    if ((document.studentForm.classOfStudent.value == null) ||
        (document.studentForm.classOfStudent.value == "")) {
        alert("Class can not be blank.");
        return false;
    }

    if (/[A-Z][a-z]*/.test(document.studentForm.classOfStudent.value) == true) {
        alert("Please enter valid class.");
        return false;
    }

    if ((document.studentForm.mail.value == null) ||
        (document.studentForm.mail.value == "")) {
        alert("Mail can not be blank.");
        return false;
    }

    var pattern = /(^[a-zA-Z0-9]+[_\-\.]?[a-zA-Z0-9]+@[a-zA-Z]+.[a-zA-Z]+$)/i
    if (!(pattern.test(document.studentForm.mail.value))) {
        alert("Invalid mail.");
        return false;
    }

    if ((document.studentForm.ageOfStudent.value == null) ||
        (document.studentForm.ageOfStudent.value == "")) {
        alert("Age can not be blank.");
        return false;
    }

    if (/[A-Z][a-z]*/.test(document.studentForm.ageOfStudent.value) == true) {
        alert("Please enter valid age.");
        return false;
    }
    return true;
}