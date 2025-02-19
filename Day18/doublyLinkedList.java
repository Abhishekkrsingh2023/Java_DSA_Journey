// package Day18;

public class doublyLinkedList {
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }
    Node head = null;
    private int size = 0;
    // Insertion
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++; // for size 
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode; // previous of head
        head = newNode; // head updation
    }
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++; // for size 
        if(head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.prev = curr;
    }
    // Print function
    public void display() {
        if(head == null) {
            System.out.println("List is Empty");
            return;
        }
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data+"<=>");
            curr = curr.next;
        }
        System.out.println("null");
    }
    public int size() {
        return size;
    }
    // Delete functions
    public void removeFirst() {
        if(head == null) {
            System.out.println("List is empty");
        }
        else if(head.next == null) {
            head = null;
            size--;
        }
        else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }
    public void removeLast() {
        if(head == null) {
            System.out.println("List is empty");
        }
        else if(head.next == null) {
            head = null;
            size--;
        }
        else {
            size--;
            Node secondLast = head;
            Node last = head.next;
            while(last.next != null)
                last = last.next;
            // deletion
            secondLast.next = null;
            last.prev = null;
        }
    }
    // Searching
    public int search(int key) {
        if(head == null) {
            return -1;
        }
        int pos = 1; // initially at 1st position
        Node curr = head;
        while(curr != null) {
            if(curr.data == key) {
                return pos;
            }
            pos++;
            curr = curr.next;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        doublyLinkedList list = new doublyLinkedList();
        // adding at the first
        list.addFirst(10);
        list.addFirst(5);
        list.addFirst(4);
        // adding at the last
        list.addLast(0);
        list.addLast(5);
        list.addLast(11);
        // display
        list.display();
        System.out.println(list.size()); // size of list
        System.out.println(list.search(11));
        System.out.println(list.search(9)); // -1(absent)
    }
}
