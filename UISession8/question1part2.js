class Node {
    constructor(element) {
        this.element = element;
        this.previous = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //function to add node
    add(element) {
        var node = new Node(element);
        var current;

        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
            node.previous = current;
            this.tail = node;
        }
        this.size++;
    }

    //function to display nodes
    showNodes() {
        if (this.head==null){
            throw "List is empty";
        }
        var currentNode = this.head;
        while (currentNode != null) {
            console.log(currentNode.element);
            currentNode = currentNode.next;
        }
    }

    //function to remove node
    remove(element) {
        var current = this.head;
        var previousNode = null;
        var flag=0;
        if (current==null){
            throw "List is empty";
        }
        while (current != null) {
            if (current.element == element) {
                flag =1;
                if (previousNode == null && current.next != null) {
                    this.head = current.next;
                } else if (current.next != null) {
                    previousNode.next = current.next;
                    current.next.previous = previousNode;
                } else {
                    current.previous = null;
                    previousNode.next = null;
                    this.tail = current.previous;
                }
            }
            previousNode = current;
            current = current.next;
        }

        if (flag==0){
            throw "Element not found";
        }

    }
}

var doubleLinkedList = new DoublyLinkedList();
while (true){
    try{

        //to get user choices
        var choice = prompt("Enter 1 to add node, 2 to delete node, 3 to show nodes and 4 to exit");
        if (choice==1){
            var value= prompt("Enter value to be added");
            doubleLinkedList.add(value);
        }
        else if (choice==2){
            var value = prompt("Enter value to be removed");
            doubleLinkedList.remove(value);
        }
        else if (choice==3){
            doubleLinkedList.showNodes();
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
