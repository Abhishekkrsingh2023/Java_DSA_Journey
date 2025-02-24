// package Day22;

public class QueueUsingArray {
    static class Queue {
        int arr[];
        private int front;
        private int rear;
        Queue(int n) { // for size of array
            arr = new int[n];
            front = rear = -1; // initially at -1 index
        }

        // isEmpty function
        public boolean isEmpty() {
            return rear == -1;
        }

        // add
        public void add(int data) {
            if(isEmpty()) {
                rear = front = 0;
                arr[rear] = data;
                return;
            }
            if(rear == arr.length-1) {
                System.out.println("Queue is full");
                return;
            }
            arr[++rear] = data; // somewhere in between
        }
        // remove
        public int remove() {
            if(isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            if(front == rear) {
                int temp = arr[front];
                front = rear = -1;
                return temp;
            }
            return arr[front++];
        }
        // front/peek
        public int front() {
            if(isEmpty()) {
                System.err.println("Queue Empty");
                return -1;
            }
            return arr[front];
        }
    } 
    public static void main(String[] args) {
        Queue q = new Queue(5); // queue of size 5
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(50); // full

        while(!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
