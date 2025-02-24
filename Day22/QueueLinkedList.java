// package Day22;

public class QueueLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class Queue {
        Node head,tail;
        Queue() {
            head = tail = null;
        }

        // isEmpty
        public boolean isEmpty() {
            return head == null;
        }

        // add
        public void add(int data) {
            Node newNode = new Node(data);
            if(isEmpty()) { // empty queue
                head = tail = newNode;
            }
            else { // Insertion through tail(rear)
                tail.next = newNode;
                tail = newNode;
            }
        }

        // remove
        public int remove() {
            int temp = -1;
            if(isEmpty()) {
                System.out.println("Queue Empty");
            }
            else if(head.next == null) { // single element
                temp = head.data;
                head = tail = null;
            }
            else {
                temp = head.data;
                head = head.next;
            }
            return temp;
        }
        // peek
        public int peek() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);

        System.out.println("Removed : "+ q.remove());
        System.out.println("Removed : "+ q.remove());

        System.out.println("Peeking/Front : "+ q.peek());
    }
}
