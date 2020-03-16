function stackImplementation() {
    this.stack = [];
}

//function to implement push operation
stackImplementation.prototype.push = function(value) {
    if (value.length==0){
        throw "Value can't be empty";
    }
    this.stack.push(value);
}

//function to implement pop operation
stackImplementation.prototype.pop = function() {
    if (this.stack.length == 0){
        throw "Stack empty."
    }
    this.stack.pop();
}

//function to implement peep operation
stackImplementation.prototype.peep = function() {
    if (this.stack.length==0){
        throw "Stack empty."
    }
    alert(this.stack[this.stack.length - 1])
}

var stackObject = new stackImplementation();
while (true){
    try{

        //getting user choices for performing desired operation
        var choice = prompt("Enter choice : 1 for push , 2 for pop , 3 for peep and 4 to exit");
        if (choice==1){
            var stackItem = prompt("Enter item to be pushed");
            stackObject.push(stackItem.trim());
        }
        else if (choice==2){
            stackObject.pop();
        }
        else if (choice==3){
            stackObject.peep();
        }
        else if (choice==4){
            break;
        }
        else{
            throw "Invalid Choice";
        }
    }
    catch (exception){
        alert(exception);
    }
}