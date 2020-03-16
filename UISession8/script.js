var iterator;
var flag =0;
var stringInput= prompt("enter the input string")

for (iterator=0;iterator<stringInput.length-1;iterator++){
    var startPosition = iterator;

    //counting consecutive similar characters
    while (stringInput.charAt(iterator)==stringInput.charAt(iterator+1)){
        flag=1;
        iterator++;
    }
    if (flag==1){
        console.log("iterator "+iterator);
        console.log("startPos "+startPosition);
        var substring = stringInput.substr(startPosition,iterator-startPosition+1);
        stringInput = stringInput.replace(substring,'');
        iterator=-1;
        flag=0;
    }
}

alert(stringInput);



