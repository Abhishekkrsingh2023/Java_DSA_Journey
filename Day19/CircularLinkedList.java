
public class CircularLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    // Circular list class
    static class CircularList {
        Node head;
        Node tail;
        CircularList() {
            head = tail = null;
        }
        private int size = 0;
        // Insertion
        public void addFirst(int data) {
            Node newNode = new Node(data);
            size++;
            if(head == null) { // empty list
                head = tail = newNode;
                tail.next = head;
            }
            else {
                newNode.next = head;
                head = newNode;
                tail.next = head;
            }
        }
        public void addLast(int data) {
            Node newNode = new Node(data);
            size++;
            if(head == null) { // empty list
                head = tail = newNode;
                tail.next = head;
            }
            else {
                newNode.next = tail.next;
                tail.next = newNode;
                tail = newNode;
            }
        }
        // size function
        public int size() {
            return size;
        }
        // deletion just using tail
        public void removeFirst() {
            if(tail == null) {
                System.out.println("Empty list");
            }
            else if(tail.next == tail) {
                tail.next = null; // unlinking the tail
                head = tail = null;
                size--;
            }
            else {
                Node temp = tail.next; // head pointer
                temp = temp.next;
                tail.next = temp;
                head = temp;
                size--;
            }
        }
        public void removeLast() {
            if(tail == null) {
                System.out.println("Empty list");
            }
            else if(tail.next == tail) {
                tail.next = null; // unlinking the tail
                head = tail = null;
                size--;
            }
            else {
                size--;
                Node secondLast = tail.next; // Start from head
                while (secondLast.next != tail) { // Stop at second last node
                    secondLast = secondLast.next;
                }
                secondLast.next = tail.next; // Update circular link
                tail = secondLast; // Update tail
            }
        }
        // display
        public void display() {
            if(head == null) System.out.print("Empty List");
            else if(head.next == head) System.out.print(head.data+"<=>"); // single Node
            else {
                Node curr = head.next;
                System.out.print(head.data+"<=>");
                while(curr != head) {
                    System.out.print(curr.data+"<=>");
                    curr = curr.next;
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        CircularList list = new CircularList();
        // list.addFirst(100);
        // list.addFirst(200);
        list.addLast(500);
        list.addLast(600);
        
        list.display();
        System.out.println(list.size());
        list.removeFirst();
        list.display();
        System.out.println(list.size());
        list.removeFirst();
        list.display();
        System.out.println(list.size());
        list.addFirst(300);
        list.display();
        System.out.println(list.size());
    }
}
