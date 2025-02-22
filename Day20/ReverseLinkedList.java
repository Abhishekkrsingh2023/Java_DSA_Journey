// package Day20;

public class ReverseLinkedList {
    class Node {
        int data;
        Node next;
        Node(int data) { // constructor
            this.data = data;
            this.next = null;
        }
    }
    Node head = null;
    public void addLast(int data) {
        Node temp = new Node(data);

        if(head == null) {
            head = temp;
            return;
        }
        Node last = head;
        while(last.next != null) {
            last = last.next;
        }
        last.next = temp; // inserting at the end
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
    // reverses the list
    public void reverseList() {
        Node prev,curr,next;
        prev = null;
        curr = head; 
        next = null;
        while(curr != null) {
            next = curr.next ;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.display();
        list.reverseList();
        list.display();
    }
}
