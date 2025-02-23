public class StackLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    static class Stack {
        Node head;
        Stack() {
            head = null;
        }

        public boolean isEmpty() {
            return head == null;
        }
        // push
        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
        //pop
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return Integer.MIN_VALUE;
            }
            int temp = head.data;
            head = head.next;
            return temp;
        }
        // peep
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return Integer.MIN_VALUE;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(54);
        s.push(33);

        System.out.println(s.peek());
        System.out.println(s.pop());
    }
}
