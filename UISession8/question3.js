function queueImplementation() {
    this.queue = []
}

//function to implement enqueue operation
queueImplementation.prototype.enqueue = function(value) {
    if (value.length==0){
        throw "Value is empty";
    }
    this.queue.push(value);
}

//function to implement dequeue operation
queueImplementation.prototype.dequeue = function() {
    if (this.queue.length==0){
        throw "Queue is empty";
    }
    this.queue.shift();
}

//function to display item at front
queueImplementation.prototype.front = function() {
    if (this.queue.length==0){
        throw "Queue is empty";
    }
    console.log(this.queue[0]);
}

//function to display item at rear position
queueImplementation.prototype.rear = function() {
    if (this.queue.length==0){
        throw "Queue is empty";
    }
    console.log(this.queue[this.queue.length - 1]);
}

var queueObject = new queueImplementation();
while (true){
    try{

        //getting user choice for performing operations.
        var choice = prompt("Enter choice : 1 for enqueue , 2 for dequeue , 3 for front element, 4 for rear element and 5 to exit");
        if (choice==1){
            var queueItem = prompt("Enter item to be pushed");
            queueObject.enqueue(queueItem.trim());
        }
        else if (choice==2){
            queueObject.dequeue();
        }
        else if (choice==3){
            queueObject.front();
        }
        else if (choice==4){
            queueObject.rear();
        }
        else if (choice==5){
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
