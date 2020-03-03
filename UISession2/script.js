$(document).ready(function() {
    //scroll to respective form on click nav tag elements
    $(".navlink").on('click', function(event) {
        if (this.hash !== "") {
            event.preventDefault();
            var hash = this.hash;
            if ($(hash).is(":hidden")) {
                $(".forms").hide();
                $(hash).show(500);
            }
            $('html, body').animate({
                scrollTop: $(hash).offset().top - 70
            }, 800);
        }
    });
});

//hides all forms initially and displays all buttons.
function hideAllForms() {
    var forms = document.getElementsByClassName("forms");
    for (let i = 0; i < forms.length; i++) {
        forms[i].style.display = "none";
    }
}

hideAllForms();

// Function to show employee registration form
function addEmployeeRegistration() {
    hideAllForms();
    document.getElementById("addEmployee").style.display = "block";
}

// Function to show vehicle registration form
function addVehicleRegistration() {
    hideAllForms();
    document.getElementById("addVehicle").style.display = "block";
}

// function to show feedback form
function addFeedback() {
    hideAllForms();
    document.getElementById("feedback").style.display = "block";
}

// function to show pricing details
function addPricing() {
    hideAllForms();
    document.getElementById("pricing").style.display = "block";
}