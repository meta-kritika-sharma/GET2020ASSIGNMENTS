String.prototype.repeatify = function(numberOfTimes){
    if (numberOfTimes<0){
        throw "Number can not be negative"
    }

    if ((this.length==0)||(this==" ")){
        throw "Input can not be empty";
    }
    var i;
    var newString = "";
    for (i=0;i<numberOfTimes;i++){
        newString = newString + this;
    }

    return newString;
}

try{
    var input = prompt("Enter input");
    var times = parseInt( prompt("Enter number of times"))
    alert(input.trim().repeatify(times))}
catch(exception){
    alert(exception);
}