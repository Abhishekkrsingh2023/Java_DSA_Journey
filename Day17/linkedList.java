// package Day17;

public class linkedList {
    class Node {
        int data;
        Node next;
        Node(int data) { // constructor
            this.data = data;
            this.next = null;
        }
    }
    private int size = 0;
    Node head = null;
    Node tail = null; // for optimized addLast Function
    // add functions
    public void addFirst(int data) {
        Node temp = new Node(data);
        size++;
        if(head==null) {
            head = temp;
            tail = temp;
            return;
        }
        temp.next = head;
        head = temp;
    }
    public void addLast(int data) {
        Node temp = new Node(data);
        size++;
        if(head == null) {
            head = temp;
            tail = temp;
            return;
        }
        Node last = head;
        while(last.next != null) {
            last = last.next;
        }
        last.next = temp; // inserting at the end
        tail = temp; // last Node
    }
    // optimized addLast function (using Tail pointer)
    public void addLastOpp(int data) {
        Node temp = new Node(data);
        size++;
        if(tail == null) {
            head = temp;
            tail = temp;
            return;
        }
        tail.next = temp;
        tail = temp;
    }

    // size
    public int size() {
        return size;
    }

    // display
    public void display() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        Node last = head;
        while(last != null) {
            System.out.print(last.data + "->");
            last = last.next;
        }
        System.out.println("null");
    }
    // Deletion
    public void deleteFirst() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next; // updating the head to its next node
        size--;
    }
    public void deleteLast() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        size--; // decrementing the size
        // single element
        if(head.next == null) {
            head = null;
            return;
        }
        Node secondlast = head;
        Node last = head.next;
        while(last.next != null) {
            secondlast = last;
            last = last.next;
        }
        secondlast.next = null; // deletion
        tail = secondlast; // updating tail
    }
    public static void main(String[] args) {
        linkedList ll = new linkedList();
        ll.addFirst(30);
        ll.addFirst(40);
        ll.addFirst(50);
        ll.addLast(25);
        ll.addLastOpp(150); // optimized addLast function
        ll.addLastOpp(166); // optimized addLast function
        ll.display();
        System.out.println(ll.size()); // size

        ll.deleteLast();
        ll.display();
        ll.addLastOpp(165);
        ll.display();
    }
}
