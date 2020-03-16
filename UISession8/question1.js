class Node {
    constructor(element) {
        this.element = element;
        this.next = null;
    }
}
class SinglyLinkedList {
    constructor() {
        this.head = null;
        this.size = 0;
    }

    //to add a node
    add(element) {
        var node = new Node(element);
        var current;
        if (this.head == null) {
            this.head = node;
        } else {
            current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        this.size++;
    }

    //to display all nodes
    showNodes() {
        var currentNode = this.head;

        //if list is empty
        if (currentNode==null){
            throw "No items found";
        }

        while (currentNode != null) {
            alert(currentNode.element);
            currentNode = currentNode.next;
        }

    }

    //to remove a node
    remove(element) {
        var current = this.head;
        var previousNode = null;
        var flag=0;

        //if list is empty
        if (current==null){
            throw "No items found";
        }
        while (current != null) {
            if (current.element == element) {
                flag=1;
                if (previousNode == null) {
                    this.head = current.next;
                } else {
                    previousNode.next = current.next;
                }
                this.size--;
            }
            previousNode = current;
            current = current.next;
        }

        if (flag==0){
            throw "Element not found";
        }
    }
}

var singleLinkedList = new SinglyLinkedList();
while (true){
    try{

        //to get user choices
        var choice = prompt("Enter 1 to add node, 2 to delete node, 3 to show nodes and 4 to exit");
        if (choice==1){
            var value= prompt("Enter value to be added");
            singleLinkedList.add(value);
        }
        else if (choice==2){
            var value = prompt("Enter value to be removed");
            singleLinkedList.remove(value);
        }
        else if (choice==3){
            singleLinkedList.showNodes();
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
