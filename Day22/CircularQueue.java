// package Day22;

public class CircularQueue {
    static class Queue {
        int arr[];
        private int front;
        private int rear;
        Queue(int n) { // for size of array
            arr = new int[n];
            front = rear = -1; // initially at -1 index
        }

        // isFull function
        public boolean isFull() {
            return (rear+1)%arr.length == front;
        }
        // isEmpty function
        public boolean isEmpty() {
            return front == -1;
        }

        // add
        public void add(int data) {
            if(isFull()) {
                System.out.println("Queue is Full");
                return;
            }
            // empty queue
            if(isEmpty()) front = 0;
            rear = (rear +1)%arr.length; // updating rear
            arr[rear] = data;
        }
        // remove
        public int remove() {
            if(isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            int temp = arr[front];
            // single element
            if(front == rear) {
                front = rear = -1;
            }
            else {
                front = (front+1)%arr.length;
            }
            return temp;
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
        Queue q = new Queue(5);
        q.add(10);
        q.add(20);
        q.add(30);

        while(!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
