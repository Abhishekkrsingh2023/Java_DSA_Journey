// package Day20;

public class MiddleOfList {
    // Node class
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
        if (head == null) {
            head = temp;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = temp; // inserting at the end
    }

    // display
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node last = head;
        while (last != null) {
            System.out.print(last.data + "->");
            last = last.next;
        }
        System.out.println("null");
    }

    // gets the middle element
    public int getMiddle() {
        if (head == null)
            return -1;
        Node slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // 1 step jump
            fast = fast.next.next; // 2 step jump
        }
        return slow.data;
    }

    public static void main(String[] args) {
        MiddleOfList list = new MiddleOfList();
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(60);
        list.addLast(70);
        list.display();
        System.out.print(list.getMiddle());

    }
}
